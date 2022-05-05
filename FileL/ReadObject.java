package FileL;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadObject {
    public static void main(String[] args) {
        try (
                var ois = new ObjectInputStream(new FileInputStream("object.txt"));
        ) {
            //从输入流读取一个对象，并强制类型转换成Person
            var p  = (Person)ois.readObject();
            System.out.println(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
