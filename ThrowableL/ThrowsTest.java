package ThrowableL;

import java.io.FileInputStream;
import java.io.IOException;

public class ThrowsTest {
    public static void main(String[] args) throws IOException {
        var fis = new FileInputStream("a.txt");
    }
}
