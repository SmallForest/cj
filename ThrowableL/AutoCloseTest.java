package ThrowableL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AutoCloseTest {
    //自动关闭资源 try后面加个圆括号
    public static void main(String[] args) throws IOException {
        try (
                //自动关闭 br.close(); java7开始支持
                var br = new BufferedReader((new FileReader("a.ini")));
        ) {
            System.out.println(br.readLine());
        }
    }
}
