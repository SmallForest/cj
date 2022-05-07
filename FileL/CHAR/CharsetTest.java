package FileL.CHAR;

import java.nio.charset.Charset;
import java.util.SortedMap;

public class CharsetTest {
    public static void main(String[] args) {
        //SortedMap名字叫map
        SortedMap<String, Charset> map = Charset.availableCharsets();
        for (var alias : map.keySet()) {
            //jvm支持的字符集
            System.out.println(map.get(alias));
        }
    }
}
