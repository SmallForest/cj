package AnnotationL;

public class Fruit {
    public void info(){
        System.out.println("水果info方法");
    }
}
class Apple extends Fruit{

    @Override
    public void info(){
        System.out.println("苹果的info");
    }
}
