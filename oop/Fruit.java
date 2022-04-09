package oop;

public class Fruit {
    public double weight;
    public void info(){
        //weight省略this.，也可以this.weight
        System.out.println("我是水果，重量"+weight+"克");
    }
}
