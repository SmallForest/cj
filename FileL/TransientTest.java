package FileL;

import java.io.*;

public class TransientTest {
    public static void main(String[] args) {
        try (
                //第一步 对象字节输出流 高级流 处理流
                var oos = new ObjectOutputStream(new FileOutputStream("o.txt"));
                var ois = new ObjectInputStream(new FileInputStream("o.txt"));
        ) {
            var per = new Person2("李红", 12);
            oos.writeObject(per);
            var p = (Person2) ois.readObject();
            //输出结果 age=0 符合预期
            System.out.println(p);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //用完就删除
            new File("o.txt").deleteOnExit();
        }
    }
}
