package oop.abstractTest;
/**
 * 计算BMW车速
 */
public class BMWCarSpeedMeter extends SpeedMeter{
    //轮毂（轮子）半径
    private double radius;
    public BMWCarSpeedMeter(){};
    public BMWCarSpeedMeter(double radius){
        this.radius = radius;
    };
    public BMWCarSpeedMeter(double radius,double tr){
        super(tr);
        this.radius = radius;
    };
    //轮毂周长 pi*r*r
    public double perimeter(){
        return Math.PI*radius*radius;
    }
    public static void main(String[] args) {
        //实例化对象，并设置半径10
        BMWCarSpeedMeter bmwCarSpeedMeter = new BMWCarSpeedMeter(10);
        bmwCarSpeedMeter.setTrunRate(10);
        var speed = bmwCarSpeedMeter.getSpeed();
        System.out.println(speed);

        BMWCarSpeedMeter bmwCarSpeedMeter2 = new BMWCarSpeedMeter(10,10);
        System.out.println(bmwCarSpeedMeter2.getSpeed());
    }
}
