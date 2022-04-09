package innerClass;

public class StaticInnerClassTest {
    private int prop1 = 5;
    private static int prop2 = 9;
    static class StaticInnerClass{
        private static int age;
        public void accessOuterProp(){
            //报错 静态内部类不可以访问非静态的变量。和之前静态方法不能访问非就静态变量时相同的
            //System.out.println(prop1);
            //正常
            System.out.println(prop2);
        }

    }
}
