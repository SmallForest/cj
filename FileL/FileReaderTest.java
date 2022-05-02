package FileL;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) {
        try (
                var fr = new FileReader("FileL/FileReaderTest.java")
        ) {
            //创建长度32的容器
            var cbuf = new char[32];
            var hasRead = 0;
            while ((hasRead = fr.read(cbuf)) > 0) {
                System.out.print(new String(cbuf, 0, hasRead));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
