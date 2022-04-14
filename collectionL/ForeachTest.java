package collectionL;

import java.util.HashSet;

public class ForeachTest {
    public static void main(String[] args) {
        //创建一个集合
        var books = new HashSet();
        //添加元素 3个
        books.add("abc");
        books.add("d");
        books.add("efg");
        for (var obj : books) {
            //没用泛型，需要强转
            var book = (String) obj;
            System.out.println(book);
        }
    }
}
