package oop;

class Singleton {
    // 1
    private Singleton(){}
    // 2
    private static Singleton s;
    // 3
    public static Singleton getInstance(){
        //实际并不可用 double check https://segmentfault.com/a/1190000040558201
        if(s==null){
            s = new Singleton();
        }
        return s;
    }
}

public class SingletonTest {
    
    public static void main(String[] args) {
        var s1 = Singleton.getInstance();
        var s2 = Singleton.getInstance();
        System.out.println(s1==s2);
    }
}
