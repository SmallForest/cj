package FileL;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class RedirectIn {
    public static void main(String[] args) {
        try (
                //定义输入流
                var fis = new FileInputStream("FileL/RedirectIn.java")
                ){
            //将标准输入重定向到fis输入流
            System.setIn(fis);
            var sc = new Scanner(System.in);
            //增加下面一行只把回车当做分隔符
            sc.useDelimiter("\n");
            //判断是否还有下一个输入项
            while (sc.hasNext()){
                System.out.println("键盘输入的内容是: "+sc.next());
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
