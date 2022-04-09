package lambdaLearn;

@interface NotNull{}
interface Predator{
    void prey(@NotNull String animal);
}
public class LambdaTest {
    public static void main(String[] args) {
        Predator predator = (@NotNull var animal)->{
            System.out.println("老鹰抓"+animal);
        };
        predator.prey("小鸡");
    }
}
