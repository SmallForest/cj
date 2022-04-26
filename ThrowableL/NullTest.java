package ThrowableL;

import java.util.Date;

public class NullTest {
    public static void main(String[] args) {
        Date d = null;
        try {
            System.out.println(d.after(new Date()));
        }catch (NullPointerException ne){
            System.out.println("空指针异常");
        }catch (Exception e){
            System.out.println("未知异常");
        }

        //要遵循先捕获小异常，再捕获大异常的准则
//        try{}catch (RuntimeException e){
//            System.out.println("运行时异常");
//        }catch (NullPointerException ne){
//            System.out.println("空指针异常");
//        }
    }


}
