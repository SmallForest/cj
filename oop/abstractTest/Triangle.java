package oop.abstractTest;

public class Triangle extends Shape{
    private double a;
    private double b;
    private double c;
    public Triangle(double a,double b,double c,String color){
        super(color);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * 周长
     */
    public double perimeter() {
        return a+b+c;
    }

    /**
     * 类型
     */
    public String getType() {
        return "三角形";
    }
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3, 4, 5,"pink");
        System.out.println(triangle.perimeter());
        System.out.println(triangle.getType());
        System.out.println(triangle.getColor());
    }
    
}
