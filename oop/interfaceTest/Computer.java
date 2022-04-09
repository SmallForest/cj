package oop.interfaceTest;

public class Computer {
    private Output out;
    public Computer(Output out){
        this.out = out;
    }
    //模拟输入
    public void keyIn(String msg){
        out.getData(msg);
    }
    //模拟打印
    public void print(){
        out.out();
    }
}
