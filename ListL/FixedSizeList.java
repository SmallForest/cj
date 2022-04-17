package ListL;

import java.util.Arrays;

public class FixedSizeList {
    public static void main(String[] args) {
        var fixedList = Arrays.asList("a","b");
        System.out.println(fixedList.getClass());
        fixedList.forEach(System.out::println);

        //尝试增加 删除元素 会报错UnsupportedOperationException
        //fixedList.add("c");
        //fixedList.remove("a");
    }
}
