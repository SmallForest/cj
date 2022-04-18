package mapL;

import java.util.HashMap;

public class MapTest {
    public static void main(String[] args) {
        var map = new HashMap();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("c", 99);
        //输出99
        System.out.println(map.put("c", 199));
        System.out.println(map);
        System.out.println(map.containsKey("d"));
        System.out.println(map.containsValue(199));
        //常规遍历
        for (var key : map.keySet()) {
            System.out.println(key + "-----" + map.get(key));
        }

        //删除一个
        map.remove("a");
        //满足k-v才会删除
        map.remove("c",200);
        //可知 c 并没有被删除
        System.out.println(map);

    }
}
