package Conversion;
public class AutoConversion {
    public static void main(String[] args) {
        int a = 6;
        //int 可转 float
        float f = a;
        System.out.println(f);
        //定义一个byte类型
        byte b = 9;
        //byte 2字节，char 1字节，无法触发自动转换
        //char c = b;
        //这样赋值OK，可以触发自动转换
        double d = b;
        System.out.println(d);

        String s = d+"";
        System.out.println(s);
        
        boolean sex = true;
        String s1 = sex+"";
        System.out.println(s1);

    }
}
