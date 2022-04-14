package collectionL;

import java.util.HashSet;

public class IteratorEach {
    public static void main(String[] args) {
        //创建一个集合
        var books = new HashSet();
        //添加元素 3个
        books.add("abc");
        books.add("d");
        books.add("efg");
        var it = books.iterator();
        it.forEachRemaining(a -> System.out.println(a));
    }
}
