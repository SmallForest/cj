package FileL;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int age;

    //未声明无参构造器 后面有用
    //声明带有两个参数的构造器
    public Person(String name, int age) {
        System.out.println("有参数的构造器");
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
