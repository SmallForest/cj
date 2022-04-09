package oop;

public class Person {
    public String name;
    public int age;
    public void say(String c)
    {
        System.out.println(c);
    }
    public static void run(){
        System.out.println("run");
    }
    public static void main(String[] args) {
        Person p = new Person();
        p.age = 50;
        p.name= "thomas";
        p.say("welcome!");
        Person p2;
        p2 = p;
        System.out.println(p2);
        Person.run();
    }
}
