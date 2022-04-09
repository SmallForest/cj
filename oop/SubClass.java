package oop;

class BaseClass {
    public int book = 6;
    public void base(){
        System.out.println("父类普通方法");
    }
    public void test(){
        System.out.println("等待被覆盖");
    }
}

public class SubClass extends BaseClass{
    public String book = "西游记";
    public void sub(){
        System.out.println("子类普通方法");
    }
    public void test(){
        System.out.println("子类覆盖父类的方法");
    }
    public static void main(String[] args) {
        //编译时类型和运行时类型不一致，存在多态。
        BaseClass bc = new SubClass();
        //输出6 属性不支持多态
        System.out.println(bc.book);
        //多态发生
        bc.test();
    }
}
