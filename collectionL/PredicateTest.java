package collectionL;

import java.util.HashSet;

public class PredicateTest {
    public static void main(String[] args) {
        var books = new HashSet();
        books.add("abc");
        books.add("abcd");
        books.add("abcde");
        //删除名字长度小于4的 也就是abc
        books.removeIf(a -> ((String) a).length() < 4);
        System.out.println(books);
    }
}
