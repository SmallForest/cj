package lambdaLearn;

public class VarInLambda {
    public static void main(String[] args) {
        //使用Lambda表达式对var变量赋值
        //必须显式指定lambda表达式的目标类型
        var run = (Runnable)()->{
            for (int i = 0; i < 100; i++) {
                System.out.println();
            }
        };
    }
}
