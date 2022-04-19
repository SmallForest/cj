package mapL;

import java.util.TreeMap;

public class SortedMapTest {
    public static void main(String[] args) {
        var s = new TreeMap();
        s.put(1,"a");
        s.put(8,"b");
        s.put(7,"c");
        s.put(6,"d");
        s.put(2,"e");
        System.out.println(s);
        System.out.println(s.tailMap(6));
        //第二个参数表示是否包含当前的元素
        System.out.println(s.tailMap(6,false));
        //比2小一点的是2
        System.out.println(s.lowerKey(6));
        s.forEach((k,v)-> System.out.println(k+"-----"+v));
    }
}
