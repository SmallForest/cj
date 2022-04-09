package oop.interfaceTest;

public class OutputFactory {
    //这个方法可以优化，比如根据不同的形参返回不同的对象
    //或者在未来需要修改Printer的时候直接修改方法体内的代码。
    public Output getOutput(){
        return new BetterPrinter();
    }
    public static void main(String[] args) {
        var of = new OutputFactory();
        var c = new Computer(of.getOutput());
        c.keyIn("A");
        c.keyIn("B");
        c.print();
    }
}
