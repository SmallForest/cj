package FileL;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) {
        try (
                //两种构造器例子
                //var raf = new RandomAccessFile("FileL/RandomAccessFileTest.java","r");
                var raf = new RandomAccessFile(new File("FileL/RandomAccessFileTest.java"), "r")
        ) {
            //获取raf对象指针的位置，初始化位置0
            System.out.println("初始化位置：" + raf.getFilePointer());
            //移动指针300 字节
            raf.seek(300);
            var bbuf = new byte[1024];
            var hasRead = 0;
            while ((hasRead = raf.read(bbuf)) > 0) {
                System.out.println(new String(bbuf, 0, hasRead));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
