package ThrowableL;

import java.io.FileInputStream;
import java.io.IOException;

public class ThrowsTest2 {
    public static void main(String[] args) throws Exception {
        test();
    }

    public static void test() throws IOException {
        //FileInputStream构造器声明throws异常FileNotFoundException extends IOException
        //所以fis需要在try-catch块包括，或者本方法也throws出去，交给调用者处理，本例正是如此
        var fis = new FileInputStream("a.txt");
    }
}
