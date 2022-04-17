package setL;

import java.util.*;

public class EnumSetTest2 {
    public static void main(String[] args) {
        var c = new HashSet();
        c.clear();
        c.add(Season.FALL);
        c.add(Season.SPRING);
        var enumSet = EnumSet.copyOf(c);
        System.out.println(enumSet);
        c.add("123");
        //此时会爆错 集合多了一个字符串类型的值
        enumSet = EnumSet.copyOf(c);
    }
}
