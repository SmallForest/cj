package oop;
class kid{
    private String name;
    private int age;
    public kid(){}
    public kid(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return "小孩 名字"+name+" 年龄"+age;
    }
}
public class ToStringTest {
    public static void main(String[] args) {
        var kid = new kid("王小二", 12);
        System.out.println(kid);
        System.out.println(kid.toString());
    }
    
}
