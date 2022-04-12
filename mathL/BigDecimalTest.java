package mathL;

import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        var f1 = new BigDecimal("0.05");
        var f2 = BigDecimal.valueOf(0.01);
        var f3 = new BigDecimal(0.05);
        System.out.println("使用String数字做构造器参数");
        System.out.println(f1.add(f2));
        System.out.println(f1.subtract(f2));
        //有精度丢失
        System.out.println("使用double数字做构造器参数");
        System.out.println(f3.add(f2));
        System.out.println(f3.subtract(f2));

        //BigDecimal 转 double
        System.out.println(f1.doubleValue());
    }
}
