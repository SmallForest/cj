package oop;

public class Construct {
    //定义构造器
    private Construct(){
        System.out.println("构造器");
    }
    private void Construct(){
        System.out.println("非构造器");
    }
    public static void main(String[] args) {
        Construct co = new Construct();
        System.out.println("调用普通方法");
        co.Construct();
    }
}
