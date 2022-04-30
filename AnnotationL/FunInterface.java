package AnnotationL;

@FunctionalInterface
public interface FunInterface {
    static void foo(){
        System.out.println("类方法");
    }
    default void bar(){
        System.out.println("bar方法");
    }
    //只定义一个抽象方法，定义多了少了都报错 只能是一个抽象方法
    void test();
}
