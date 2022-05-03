package FileL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyinTest {
    public static void main(String[] args) {
        try (
                //将System.in 对象转换成Reader对象
                var reader = new InputStreamReader(System.in);
                //将普通的Reader包装成BufferedReader
                var br = new BufferedReader(reader);
                ) {
            String line = null;
            while ((line=br.readLine())!=null){
                //读取到 exit 字符就退出JVM
                if (line.equals("exit")){
                    System.exit(1);
                }
                System.out.println(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
