package ThrowableL;

public class ThrowTest {
    public static void main(String[] args) {
        try {
            throwChecked(-3);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        throwRuntime(3);
    }


    public static void throwChecked(int a)throws Exception{
        if (a>0){
            //必须抛出或者显式捕获，不然检查不通过
            throw new Exception("异常");
        }
    }

    public static void throwRuntime(int a){
        if (a>0){
            //可以抛出异常，显式捕获异常
            //也可以不用理会
            throw new RuntimeException("运行时异常");
        }
    }

}
