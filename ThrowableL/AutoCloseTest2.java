package ThrowableL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AutoCloseTest2 {
    public static void main(String[] args) throws IOException {
        //必须是final修饰或者有效的final
        final var br = new BufferedReader((new FileReader("a.ini")));

        //java9开始拥有的特点
        try (
                br
        ) {
            System.out.println(br.readLine());
        }
    }
}
