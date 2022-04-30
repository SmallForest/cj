package AnnotationL;

class Fruit1 {
    //定义info()已过时
    //since指定开始版本，forRemoval指定将来是否被删除
    @Deprecated(since = "9",forRemoval = true)
    public void info(){
        System.out.println("水果info方法");
    }
}

public class DeprecatedTest {
    public static void main(String[] args) {
        //提示错误
        new Fruit1().info();
    }
}
