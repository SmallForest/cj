package FileL;

import java.io.*;
import java/*插入的内容*/.nio.charset.StandardCharsets;

public class InsertContent {
    public static void insert(String fileName, long pos, String insertContent) throws IOException {
        //创建临时文件存储
        var tmp = File.createTempFile("tmp", null);
        //声明删除钩子
        tmp.deleteOnExit();
        try (
                var raf = new RandomAccessFile(fileName, "rw");
                //字节输出流
                var tmpOut = new FileOutputStream(tmp);
                //字节输入流
                var tmpIn = new FileInputStream(tmp)
        ) {
            raf.seek(pos);
            //下面将pos后面的内容存储到临时文件中
            var bbuf = new byte[64];
            var hasRead = 0;
            while ((hasRead = raf.read(bbuf)) > 0) {
                tmpOut.write(bbuf, 0, hasRead);
            }

            //读取完数据pos，跑到了末尾 需要重置
            raf.seek(pos);
            System.out.println(raf.getFilePointer());
            //下面将插入内容
            raf.write(insertContent.getBytes(StandardCharsets.UTF_8));

            System.out.println(raf.getFilePointer());
            //追加临时文件中内容，ps此时pos已经在末尾了
            while ((hasRead = tmpIn.read(bbuf)) > 0) {
                raf.write(bbuf, 0, hasRead);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        insert("FileL/InsertContent.java", 45, "/*插入的内容*/");
    }
}
