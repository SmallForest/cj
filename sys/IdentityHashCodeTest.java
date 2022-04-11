package sys;

public class IdentityHashCodeTest {
    public static void main(String[] args) {
        //s1 s2不同的对象
        var s1 = new String("hi");
        var s2 = new String("hi");
        //因为String类重写了hashCode 。比较s1 s2会是相等的
        //因为s1 s2序列相同
        System.out.println(s1.hashCode()+"=="+s2.hashCode());
        //但是identityHashCode是不相同的。
        System.out.println(System.identityHashCode(s1)+"=="+System.identityHashCode(s2));
        var s3 = "hello";
        var s4 = "hello";
        //s3 s4是相同的字符串对象，identityHashCode相等。
        //主要是因为s3 s4是直接量，没堆空间 都在栈里
        System.out.println(System.identityHashCode(s3)+"=="+System.identityHashCode(s4));

    }
}
