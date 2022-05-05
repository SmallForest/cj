package FileL;

import java.io.*;

//A不可序列化
class A {
    public int age;

    //声明无参构造器
    public A(){}
}

//B继承A 并且可序列化
class B extends A implements Serializable {
    public String name;

    //声明有参构造器
    public B(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "B{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class WriteReadObject {
    public static void main(String[] args) {
        try (
                //第一步 对象字节输出流 高级流 处理流
                var oos = new ObjectOutputStream(new FileOutputStream("o.txt"));
                var ois = new ObjectInputStream(new FileInputStream("o.txt"));
        ) {
            var p = new B("恐龙", 600);
            // 第二步 写入对象到输出流
            oos.writeObject(p);

            //第三步 从输入流读取一个对象，并强制类型转换成B
            var pNew = (B) ois.readObject();
            //如果父类是不可序列化的，但是带有无参构造器，则该父类中定义的变量值不会序列化到二进制流中。
            //因此age=0
            System.out.println(pNew);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //用完就删除
            new File("o.txt").deleteOnExit();
        }
    }
}
