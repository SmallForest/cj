package oop.interfaceTest;

public class CommandTest {
    public static void main(String[] args) {
        var pa = new ProcessArray();
        var cmd = new PrintCommand();
        var cmd2 = new SquareCommand();
        int[] target = {1,2,3};
        pa.process(target, cmd);
        pa.process(target, cmd2);

        //匿名内部类使用
        pa.process(target, new Command() {
            public void process(int e){
                System.out.println("三次方："+(e*e*e));
            }
        });
        //lambda表达式优化匿名内部类实例的创建方式
        pa.process(target, (int e)->{
            System.out.println("四次方！lambda："+(e*e*e*e));
        }
        );

    }
}
