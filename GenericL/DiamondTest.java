package GenericL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiamondTest {
    public static void main(String[] args) {
        //类型推断
        List<String> books = new ArrayList<>();
        books.add("a");
        books.forEach(a -> System.out.println(a.length()));

        //HashMap
        Map<String, List<String>> s = new HashMap<>();
        List<String> sl = new ArrayList<>();
        sl.add("aa");
        s.put("笑嘻嘻", sl);
        s.forEach((k, v) -> System.out.println(k + "----" + v));
    }
}
