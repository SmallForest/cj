package GenericL;

public class Rectangle extends Shape{
    @Override
    public void draw(Canvas c) {
        System.out.println("在画布"+c+"画了一个矩形");
    }
}
