package CollectionsL;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Java9Collection {
    public static void main(String[] args) {
        //创建不可变Set
        var set = Set.of("a","b","c","d");
        //这是错误的
        //set.remove("a");

        var list = List.of(12,23,45,6,7);
        //这是错误的
        //list.clear();

        //map
        var map = Map.of("语文",98,"数学",100);
        System.out.println(map);
        //这是错误的
        //map.remove("数学");

        //或者显式声明k-v
        var map2 = Map.ofEntries(Map.entry("语文",98)
        ,Map.entry("数学",100));
        System.out.println(map2);
    }
}
