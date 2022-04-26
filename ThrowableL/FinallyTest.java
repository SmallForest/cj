package ThrowableL;

import java.io.FileInputStream;
import java.io.IOException;

public class FinallyTest {
    public static void main(String[] args) {
        //fis不能声明在try{}内，防止finally无法关闭
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("a.txt");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            //直接return，finally内代码正常执行
            //return;
            //退出虚拟机，finally内代码得不到执行
            System.exit(1);
        } finally {
            //关闭磁盘文件，回收资源
            if (fis != null) {
                //异常处理的嵌套
                try {
                    fis.close();
                } catch (IOException ioe) {
                    //输出异常栈信息
                    ioe.printStackTrace();
                }
            }
            System.out.println("资源回收");
        }
    }
}
