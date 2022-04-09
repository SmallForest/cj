package Conversion;

public class PrimitiveAndString {
    public static void main(String[] args) {
        //一个基本类型的值和字符串进行连接运算的时候，基本类型的值自动转字符串
        String s = 3.5f+"";
        System.out.println(s);
        //下面输出 7Hello! 从左到右先计算了3+4=7 后7+"Hello!"
        System.out.println(3+4+"Hello!");
        //下面输出Hello!34 同理
        System.out.println("Hello!"+3+4);
    }
}
