package oop.interfaceTest;
interface Product{
    //自动添加public abstract
    int getProduceTime();
}
public class Printer implements Output,Product {
    private String[] printData = new String[MAX_CACHE_LINE];
    //当前需要打印的数量
    private int dataNum = 0;

    //重写接口中的抽象类
    public void out(){
        //打印
        while(dataNum>0){
            System.out.println("打印机打印："+printData[0]);
            //把作业队列整体向前移动1位
            System.arraycopy(printData, 1, printData, 0, --dataNum);
        }
    }

    //获取数据
    public void getData(String msg){
        if(dataNum>=MAX_CACHE_LINE){
            System.out.println("队列满了");
        }else{
            printData[dataNum++] = msg;
        }
    }

    public int getProduceTime(){
        return 45;
    }

    public static void main(String[] args) {
        Output o = new Printer();
        o.getData("a");
        o.getData("b");
        o.out();
        o.getData("c");
        o.getData("d");
        o.out();
        o.print("e","f");
        o.test();
         
        Product p = new Printer();
        System.out.println(p.getProduceTime());
        //所有接口类型的引用变量都可以赋值给Object
        Object obj = p;
    
    }
}
