package innerClass;
//牛🐂
public class Bull {
    private double weight;
    public Bull(){};
    public Bull(double weight){
        this.weight = weight;
    };
    //非静态内部类，no static
    //牛大腿
    private class Leg{
        private double length;
        private String color;
        public Leg(){};
        public Leg(double length,String color){
            this.color = color;
            this.length = length;
        };
        //内部类的实例方法
        public void info(){
            System.out.println("当前牛腿颜色"+color+"，高"+length);
            //直接访问外部类的变量
            System.out.println("本牛腿在的牛重量"+weight);
        }
    }
    public void test(){
        Leg l = new Leg(1.2, "红色");
        //调用内部类实例方法
        l.info();
    }
    public static void main(String[] args) {
        var b = new Bull(300);
        b.test();
    }

}
