package mapL;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        var tm = new TreeMap();
        tm.put(1,"a");
        tm.put(13,"a");
        tm.put(5,"a");
        tm.put(2,"a");
        System.out.println(tm);
        var s = tm.keySet();
        System.out.println(s);
        var i = Arrays.binarySearch(s.toArray(),5);
        System.out.println(i);

        System.out.println(tm.get(5));
    }
}
