package innerClass;
interface Product{
    double getPrice();
    String getName();
}
/**
 * 匿名内部类
 */
public class AnonymousTest {
    public void test(Product p){
        System.out.println("购买了"+p.getName()+"，花掉了"+p.getPrice());
    }
    public static void main(String[] args) {
        var at = new AnonymousTest();
        at.test(new Product() {
            public double getPrice(){
                return 19999;
            }
            public String getName(){
                return "QJMOTOR";
            }
        });
    }
}
