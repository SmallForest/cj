package oop.interfaceTest;

/**
 * 高速打印机
 */
public class BetterPrinter implements Output{
    private String[] printData = new String[MAX_CACHE_LINE];
    //当前需要打印的数量
    private int dataNum = 0;

    //重写接口中的抽象类
    public void out(){
        //打印
        while(dataNum>0){
            System.out.println("高速！打印机打印："+printData[0]);
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
}
