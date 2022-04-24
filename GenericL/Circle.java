package GenericL;

public class Circle extends Shape{
    //实现画图方法
    @Override
    public void draw(Canvas c){
        System.out.println("在画布"+c+"上画个圆圈");
    }
}
