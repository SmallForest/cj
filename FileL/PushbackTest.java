package FileL;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

public class PushbackTest {
    public static void main(String[] args) {
        try (
                //创建一个PushbackReader对象，指定缓冲区的长度64
                var pr = new PushbackReader(new FileReader("FileL/PushbackTest.java"), 64)
        ) {
            var buf = new char[32];
            //用来保存上次读取的字符串内容
            var lastContent = "";
            var hasRead = 0;
            //循环读取文件内容
            while ((hasRead = pr.read(buf)) > 0) {
                //将读取的内容转换成字符串
                var content = new String(buf, 0, hasRead);
                var targetIndex = 0;
                //将上次读取到的字符串和本次读取到的字符串拼接起来
                //查看是否包含模板字符串，如果包含目标字符串
                if ((targetIndex = (lastContent + content).indexOf("new PushbackReader")) > 0) {
                    //将本次内容和上次内容一起推回缓冲区
                    pr.unread((lastContent + content).toCharArray());
                    //重新定义一个长度为targetIndex的char数组
                    if (targetIndex > 32) {
                        buf = new char[targetIndex];
                    }
                    //再次读取指定长度内容
                    pr.read(buf, 0, targetIndex);
                    //打印读取的内容
                    System.out.println(new String(buf, 0, targetIndex));
                    System.exit(0);
                } else {
                    //打印上次读取的内容
                    System.out.println(lastContent);
                    lastContent = content;
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
