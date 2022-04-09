package oop.interfaceTest;

public interface Output {
    //接口里定义的成员变量只能是常量
    int MAX_CACHE_LINE = 12;

    //抽象方法 自动添加public abstract 因此可省略
    void out();
    void getData(String msg);

    //在接口定义默认方法，default修饰
    default void print(String ...msgs){
        for (String msg : msgs) {
            System.out.println(msg);
        }
    }
    // 默认方法就是实例方法
    default void test(){
        System.out.println("接口中的test()");
    }

    static void staticTest(){
        System.out.println("静态方法，类方法");
    }

    private void foo(){
        System.out.println("私有方法");
    }

    private static void bar(){
        System.out.println("私有静态方法");
    }
    
}
