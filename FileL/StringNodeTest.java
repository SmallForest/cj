package FileL;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringNodeTest {
    public static void main(String[] args) {
        var src = "从明天起做个幸福的人";
        var buffer = new char[32];
        var hasRead = 0;
        try (
                //字符输入流
                var sr = new StringReader(src)
                ){
            //读取字符串
            while ((hasRead=sr.read(buffer))>0){
                System.out.println(new String(buffer,0,hasRead));
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

        //第二部分
        try (
                //创建StringWriter时，实际上以一个StringBuffer作为输出节点
                //下面的20就是StringBuffer的初始长度，因为StringBuffer可变长
                var sw  = new StringWriter(20)
                ){
            //向输出流写入字符
            sw.write("美丽的");
            sw.write("新世界");
            sw.write("欢迎每个人");
            System.out.println("----sw----");
            System.out.println(sw.toString());
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
