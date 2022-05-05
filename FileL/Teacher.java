package FileL;

import java.io.*;

public class Teacher implements Serializable {
    private String name;
    //Teacher类实现了接口Serializable，这时能不能序列化要看 Person 能不能序列化了~
    //如果 Person不可序列化，将爆 NotSerializableException 异常
    private Person Student;

    public Teacher(String name, Person student) {
        this.name = name;
        this.Student = student;
    }

    public static void main(String[] args) {
        //尝试序列化一下
        try (
                //第一步 对象字节输出流 高级流 处理流
                var oos = new ObjectOutputStream(new FileOutputStream("o.txt"));
        ) {
            var stu = new Person("李明",12);
            var teacher = new Teacher("恐龙", stu);
            // 第二步 写入对象到输出流
            oos.writeObject(teacher);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //用完就删除
            new File("o.txt").deleteOnExit();
        }
    }
}
