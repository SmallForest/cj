package oop.abstractTest;

/**
 * 抽象类 Shape形状
 */
public abstract class Shape {
    {
        System.out.println("抽象类初始化");
    }
    static {
        System.out.println("抽象类初始化-静");
    }
    private String color;
    //定义个返回周长的抽象方法
    public abstract double perimeter();
    //定义返回类型的的抽象方法
    public abstract String getType();
    //定义构造器
    public Shape(){
        System.out.println("Shape构造方法");
    }
    //构造器重载
    public Shape(String color){
        System.out.println("颜色是"+color);
        this.color = color;
    }
    //定义普通方法
    public String getColor(){
        return color;
    }
}
