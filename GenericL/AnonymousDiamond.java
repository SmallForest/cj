package GenericL;

interface Foo<T> {
    void test(T t);
}

public class AnonymousDiamond {
    public static void main(String[] args) {
        Foo<String> f = new Foo<>() {
            @Override
            public void test(String t) {
                System.out.println("test t参数是：" + t);
            }
        };
        f.test("乌贼");

        Foo<String> ff = a -> System.out.println("我用lambda表达式获取：" + a);
        ff.test("大王");

        //泛型通配符 （后面提到）?表示 上限为Object
        Foo<?> fo = new Foo<>() {
            @Override
            public void test(Object t) {
                System.out.println("Object的类型" + t);
            }
        };
        fo.test(null);
        //这样写有问题
        //fo.test(new String("1234"));

        //上限为Number，Number是6个数值类型的父类
        Foo<? extends Number> fn = new Foo<>() {
            @Override
            public void test(Number t) {
                System.out.println("Number : "+t);
            }
        };
        //有问题待定
        //fn.test(new Integer(1));
        //fn.test(2.11);

    }
}
