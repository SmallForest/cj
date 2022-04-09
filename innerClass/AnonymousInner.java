package innerClass;
abstract class Device{
    private String name;
    public abstract double getPrice();
    public Device(){};
    public Device(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
public class AnonymousInner {
    public void test(Device d){
        System.out.println("购买了"+d.getName()+"，花掉了"+d.getPrice());
    }
    public static void main(String[] args) {
        var ai = new AnonymousInner();
        ai.test(new Device("MBP") {
            public double getPrice(){
                return 19999;
            }
        });

        var d = new Device() {
            {
                System.out.println("初始化块");
            }
            //实现抽象方法
            public double getPrice(){
                return 100;
            }
            //overwrite父类
            public String getName(){
                return "罗技鼠标";
            }
        };
        ai.test(d);
    }
}
