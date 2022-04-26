package ThrowableL;

public class MultiExceptionTest {
    public static void main(String[] args) {
        try{
            var a= Integer.parseInt(args[0]);
            var b= Integer.parseInt(args[1]);
            var c = a/b;
            System.out.println(c);
        }catch (IndexOutOfBoundsException|NumberFormatException|ArithmeticException ie){
            System.out.println("三个异常 一起捕获");
            //多捕获异常时，ie有final关键词修饰，不能赋值
            //ie = new ArithmeticException("123");
        }catch (Exception e){
            System.out.println("未知异常");
            //非多捕获异常，e没有被final修饰，赋值是完全OK的
            e=new RuntimeException("1234");
        }
    }
}
