package innerClass;
interface A{
    void test();
}
public class ATest {
    public static void main(String[] args) {
        int age = 8;
        //给age赋值会报错,飘红色。Java8之前显示声明final int age = 8; 之后不用
        //age = 19;
        var a = new A() {
            public void test(){
                //匿名内部类中使用了age
                System.out.println(age);
            }
        };
        a.test();
    }
}
