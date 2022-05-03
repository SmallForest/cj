package FileL;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {
    public static void main(String[] args) {
        try (
                //节点流，字节输出流
                var fos = new FileOutputStream("test.txt");
                //处理流 包装流
                var ps = new PrintStream(fos);
        ) {
            //直接输出，方法简单
            ps.println("一个字符串");
            //输出一个对象
            ps.println(new PrintStreamTest());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }finally {
            //测试完就删除文件
            new File("test.txt").deleteOnExit();
        }
    }
}
