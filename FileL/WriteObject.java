package FileL;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) {
        try (
                //第一步 对象字节输出流 高级流 处理流
                var oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
        ) {
            var p = new Person("小明", 40);
            // 第二步 写入对象到输出流
            oos.writeObject(p);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
