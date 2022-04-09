package Conversion;

public class AutoPromote {
    public static void main(String[] args) {
        //定义short类型5
        // short s = 5;
        //赋值出错。右侧表达式s-2 s是short 2是int，表达式整体提升int。因为左侧s类型是小范围类型short无法自动类型转换，所以报错
        //s = s-2;
        byte b = 40;
        //char
        var c = 'a';
        //int
        var i = 23;
        //默认double
        var d = .314;
        //表达式最终结果类型double，因为其中范围最大的就属double的d了
        double result = b+c+i+d;
        System.out.println(result);
        //表达式的类型将严格保持和表达式中最高等级操作数相同的类型。
        //这也就是为什么两个int即使除不尽，结果仍然是int的原因
        var val = 3;
        int intRes = 23/val;
        System.out.println(intRes);
    }
}
