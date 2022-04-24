package GenericL;

class MyClass<E> {
    public <T> MyClass(T t) {
        System.out.println("t:" + t);
    }
    //表示返回值类型是E类型的,参数也是E类型
    public E getE(E name){
        return name;
    }
}

public class GenericDiamondTest {
    public static void main(String[] args) {
        //MyClass<String>表示MyClass的E是String。
        //T的类型未显示声明
        //MyClass<>会进行推断，得到MyClass<String>
        MyClass<String> mc1 = new MyClass<>(5);
        System.out.println(mc1.getE("中国"));

        //MyClass<String>表示MyClass的E是String。
        // <Integer>MyClass表示泛型构造器中T的类型是Integer
        //MyClass<String> 相同与上面的
        MyClass<String> mc2 = new <Integer>MyClass<String>(5);
        //错误 显示声明了构造器的泛型参数类型，菱形语法不可用，失效
        //MyClass<String> mc3 = new <Integer>MyClass<>(5);
    }
}
