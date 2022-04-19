package mapL;

import java.util.EnumMap;

enum Season {
    SPRING, SUMMER, FALL, WINTER
}

public class EnumMapTest {
    public static void main(String[] args) {
        var eM = new EnumMap(Season.class);
        eM.put(Season.SUMMER, "夏天");
        eM.put(Season.SPRING, "春天");
        //顺序
        System.out.println(eM);
    }
}
