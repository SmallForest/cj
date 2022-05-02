package FileL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) {
        try (
                //创建字节输入流
                var fis = new FileInputStream("FileL/FileOutputStreamTest.java");
                //创建字节输出流
                var fos = new FileOutputStream("FileL/newFile.txt")
        ) {
            var bbuf = new byte[32];
            var hasRead = 0;
            //循环从输入流取出数据
            while ((hasRead = fis.read(bbuf)) > 0) {
                //写入到newFile.txt
                fos.write(bbuf, 0, hasRead);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            //创建后就删除
            new File("FileL/newFile.txt").deleteOnExit();
        }
    }
}
