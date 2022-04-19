package mapL;

import java.util.HashMap;

public class HashMapErrorTest {
    public static void main(String[] args) {
        var hm = new HashMap();
        //复用A类
        hm.put(new A(60000),"a");
        hm.put(new A(87563),"b");
        System.out.println(hm);
        //获得迭代器 Set的迭代器
        var it = hm.keySet().iterator();
        var first = (A)it.next();
        //60000->87563
        first.count = 87563;
        //此时的key看着相同了？
        System.out.println(hm);
        //此时删除只可以删除原来的
        hm.remove(new A(87563));
        System.out.println(hm);
        //获取原来的两个值 均提示获取不到
        System.out.println(hm.get(new A(87563)));
        System.out.println(hm.get(new A(60000)));
        //此时就会导致，原来key=A{count=60000}的再也读取不到了，是个BUG。
    }
}
