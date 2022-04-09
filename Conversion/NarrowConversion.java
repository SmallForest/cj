package Conversion;

public class NarrowConversion {
    public static void main(String[] args) {
        var iValue = 233;
        //强制把int转byte
        byte bValue = (byte)iValue;
        //输出-23 溢出造成的错误
        System.out.println(bValue);

        //默认double
        var dValue = 3.98;
        //将double 3.98转int 直接截取整数部分3，小数部分舍弃！
        int i = (int)dValue;
        //得到3
        System.out.println(i);
    }
}
