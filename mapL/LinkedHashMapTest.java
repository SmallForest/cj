package mapL;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        var scores = new LinkedHashMap();
        scores.put("语文", 99);
        scores.put("数学", 99);
        scores.put("外语", 99);
        scores.forEach((k, v) -> System.out.println(k + "---" + v));
    }
}
