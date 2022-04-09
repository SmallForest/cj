package overload;

public class Overload {
    public void test()
    {
        System.out.println("无参数");
    }
    public void test(String msg)
    {
        System.out.println("第二个test"+msg);
    }
    public static void main(String[] args) {
        var ol = new Overload();
        //调用第一个方法
        ol.test();
        //调用第二个方法
        ol.test("hello");
    }
}
