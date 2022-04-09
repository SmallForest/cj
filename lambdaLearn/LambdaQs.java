package lambdaLearn;

interface Eatable{
    void taste();
}
interface Flyable{
    void fly(String weather);
}
interface Addable{
    int add(int a,int b);
}
public class LambdaQs {
    //调用该方法需要Eatable方法
    public void eat(Eatable e){
        System.out.println(e);
        e.taste();
    }
    public void drive(Flyable f){
        System.out.println("我正在驾驶");
        f.fly("天气很好");
    }
    public void test(Addable add){
        System.out.println("5+3="+add.add(5, 3));
    }

    public static void main(String[] args) {
        var lq = new LambdaQs();
        //lambda表达式代码一行可以省略花括号，或者只有一套return语句还可以接着省略return！
        lq.eat(()->System.out.println("尝起来是美味的"));

        //一个形参可以省略圆括号。
        lq.drive(weather->{
            System.out.println("今天天气"+weather);
        });

        //取消 {} 和return
        lq.test((a,b)->a+b);

    }
}
