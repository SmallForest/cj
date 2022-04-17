package mapL;

import java.util.HashMap;
import java.util.function.BiFunction;

public class iteratorMapTest {
    public static void main(String[] args) {
        var hm = new HashMap();
        hm.put("a", 1);
        hm.put("b", 2);
        hm.put("c", 3);
        hm.put(null, 4);
        System.out.println(hm);
        //foreach+keySet
        for (var k : hm.keySet()) {
            System.out.println(k + "----" + hm.get(k));
        }
        //forEach 形参是v k顺序
        hm.forEach((v, k) -> System.out.println(k + "----" + v));

        //replaceAll
        hm.replaceAll((k, v) -> {
            System.out.println(k + "---" + v);
            return v;
        });
        System.out.println(hm);
    }
}
