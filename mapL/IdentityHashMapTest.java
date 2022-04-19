package mapL;

import java.util.IdentityHashMap;

public class IdentityHashMapTest {
    public static void main(String[] args) {
        var ihm = new IdentityHashMap();
        //两个都可以添加进去
        ihm.put(new String("a"), 1);
        ihm.put(new String("a"), 1);
        //下面的只能添加1个。这就是直接量和对象之间的不同导致的
        ihm.put("b", 1);
        ihm.put("b", 1);

        ihm.put(null, null);
        System.out.println(ihm);
    }
}
