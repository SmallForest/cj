package GenericL;

class Foo1 {
    //泛型构造器
    public <T> Foo1(T t) {
        System.out.println(t);
    }
}

public class GenericConstructor {
    public static void main(String[] args) {
        //泛型构造器 T类型为String
        new Foo1("abc");
        //泛型构造器，T类型为integer
        new Foo1(100);

        //显示指定泛型构造器中的T类型为String 也是OK的
        new <String>Foo1("eg");
        //显示指定泛型构造器中的T类型为String 实参类型不符合，爆错。
        //new <String>Foo1(123);
    }
}
