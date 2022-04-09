package oop.interfaceTest;

public class ProcessArray {
    //定义一个实例方法，接收一个Command的实例对象。（未来
    //第二个参数需要是实现了Command interface的对象）
    public void process(int[] target,Command cmd){
        for (int i : target) {
            cmd.process(i);
        }
    }
}

/**
 * 此类仅仅是输出
 */
class PrintCommand implements Command{
    public void process(int e){
        System.out.println("仅仅是输出"+e);
    }
}

/**
 * 输出平方
 */
class SquareCommand implements Command{
    public void process(int e){
        System.out.println("输出平方"+(e*e));
    }
}