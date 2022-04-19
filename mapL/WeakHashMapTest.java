package mapL;

import java.util.WeakHashMap;

public class WeakHashMapTest {
    public static void main(String[] args) {
        var whm = new WeakHashMap();
        whm.put(new String("a"),1);
        whm.put(new String("b"),1);
        whm.put(new String("c"),1);
        //上面3个参数key,都是匿名字符串对象（没有被其他变量引用）
        //添加一个字符串对象，直接量形式的。不会被GC清除
        whm.put("d",1);
        System.out.println(whm);
        System.gc();
        System.runFinalization();
        //只剩下了d
        System.out.println(whm);
    }
}
