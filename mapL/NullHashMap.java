package mapL;

import java.util.HashMap;

public class NullHashMap {
    public static void main(String[] args) {
        var hm = new HashMap();
        //放入null 当做k-v
        hm.put(null,null);
        hm.put(null,null);
        hm.put("a",null);
        System.out.println(hm);
    }
}
