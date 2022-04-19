package mapL;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws Exception {
        var props = new Properties();
        //
        props.setProperty("username", "smallforest");
        props.setProperty("pwd", "1234");
        props.store(new FileOutputStream("a.ini"), "new line");
        //
        var props2 = new Properties();
        props2.setProperty("gender", "1");
        //读取a.ini
        props2.load(new FileInputStream("a.ini"));
        System.out.println(props2);
    }
}
