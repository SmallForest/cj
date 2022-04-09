package oop;

public class Apple {
    public String name;
    public String color;
    public double weight;
    //无参构造器
    public Apple(){}
    //第二个构造器
    public Apple(String name,String color){
        this.name = name;
        this.color =color;
    }
    public Apple(String name,String color,double weight){
        //调用第二个构造器
        this(name,color);
        this.weight = weight;
    }
    public static void main(String[] args) {
        var apple = new Apple("蛇果","蓝色",13.23);
        System.out.println(apple.name);
    }
}
