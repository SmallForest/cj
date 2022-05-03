package FileL;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class RedirectOut {
    public static void main(String[] args) {
        try (
                //包装流，高级流，处理流包装节点流
                var ps = new PrintStream(new FileOutputStream("out.txt"))
        ) {
            //将标准输出重定向到ps输出流
            System.setOut(ps);
            //向标准输出输出一个字符串
            System.out.println("字符串");
            //向标准输出输出一个对象
            System.out.println(new RedirectOut());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            //测试完毕删除
            new File("out.txt").deleteOnExit();
        }
    }
}
