package GenericL;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        //Object是String的父类
        TreeSet<String> ts1 = new TreeSet<>(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.hashCode()>o2.hashCode()?1:o1.hashCode()<o2.hashCode()?-1:0;
            }
        });
        ts1.add("c");
        ts1.add("b");
        ts1.add("d");
        ts1.add("a");
        System.out.println(ts1);

        TreeSet<String> ts2 = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.hashCode()>s2.hashCode()?1:s1.hashCode()<s2.hashCode()?-1:0;
            }
        });
        ts2.add("c");
        ts2.add("b");
        ts2.add("d");
        ts2.add("a");
        System.out.println(ts2);
    }
}
