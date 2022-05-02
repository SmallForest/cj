package FileL;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        //创建字节输入流
        var fis = new FileInputStream("FileL/FileInputStreamTest.java");
        //创建长度1024bytes的容器
        var bbuf = new byte[1024];
        var hasRead = 0;
        //使用循环来重复读取数据
        while ((hasRead = fis.read(bbuf)) > 0) {
            System.out.print(new String(bbuf, 0, hasRead));
        }
        //不是安全关闭
        fis.close();
    }
}
