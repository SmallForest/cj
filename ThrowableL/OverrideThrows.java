package ThrowableL;

import java.io.FileInputStream;
import java.io.IOException;

public class OverrideThrows {
    public void test() throws IOException{
        var fis = new FileInputStream("a.txt");
    }
}
class Sub extends OverrideThrows{
    //子类重写父类方法，抛出的异常要比父类方法的小（继承角度小），并且数量不多于父类方法
    //public void test() throws Exception{

    //}
}
