package oop;

public class ConstructorTest {
    public String name;
    public int count;
    public ConstructorTest(String name,int count){
        this.name = name;
        this.count = count;
    }

    public ConstructorTest(String name){
        this.name = name;
    }

    public static void main(String[] args) {
        var tc = new ConstructorTest("超级玛丽", 100);
        System.out.println(tc.name);
        System.out.println(tc.count);

        var tc1 = new ConstructorTest("小明");
        System.out.println(tc1.name);
    }
}
