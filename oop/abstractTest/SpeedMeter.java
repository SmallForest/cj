package oop.abstractTest;

/**
 * 车速表
 */
public abstract class SpeedMeter {
    //转速
    private double turnRate;
    
    //构造器
    public SpeedMeter(){};
    public SpeedMeter(double tr){
        turnRate=tr;
    };

    //设置转速
    public void setTrunRate(double tr){
        turnRate=tr;
    }
    
    //获取周长 不同的”寸“轮毂周长不同 此类无法直接指定。因此定义抽象方法
    public abstract double perimeter();
    
    //求车速=轮子周长*转速
    public double getSpeed(){
        return turnRate*perimeter();
    }
}
