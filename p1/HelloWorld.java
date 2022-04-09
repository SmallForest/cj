public class HelloWorld{
    public static void main(String[] args){
        System.out.println("Hello World!");
        HelloWorld2 h2 = new HelloWorld2();
        System.out.println(h2.a);
        h2.test();
    }
}
class HelloWorld2{
    protected int a = 100;
    
    public void test(){
        System.out.println("Hello Test!");
    }
    
}