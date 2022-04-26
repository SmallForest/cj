package ThrowableL;

import java.io.FileInputStream;
import java.io.IOException;

public class AccessExceptionMsg {
    public static void main(String[] args) {
        try{
            var fis = new FileInputStream("a.txt");
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
            //异常栈信息输出到CMD
            ioe.printStackTrace();
        }
    }
}
