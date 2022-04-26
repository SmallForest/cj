package ThrowableL;

public class FinallyFlowTest {
    public static void main(String[] args) {
        boolean a = test();
        System.out.println(a);
    }
    public static boolean test(){
        try{
            return true;
        }finally {
            //优先级更高
            return false;
        }
    }
}
