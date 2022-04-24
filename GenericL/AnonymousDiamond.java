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

        //泛型通配符 （后面提到）?表示 上限为Object ?表示不知道类型
        Foo<?> fo = new Foo<>() {
            @Override
            public void test(Object t) {
                System.out.println("Object的类型" + t);
            }
        };
        fo.test(null);
        //由于fo无法被直接调用，所以只能强制转型为子类型
        var s = (Foo<String>) fo;
        s.test("22");

        //上限为Number，Number是6个数值类型的父类 这种指定通配符上限的也不能写入，同样也是因为不知道元素类型
        Foo<? extends Number> fn = new Foo<>() {
            @Override
            public void test(Number t) {
                System.out.println("Number : " + t);
            }
        };
        var fn1 = (Foo<Integer>) fn;
        fn1.test(22);

    }
}
