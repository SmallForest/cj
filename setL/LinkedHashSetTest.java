package setL;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {
    public static void main(String[] args) {
        var books = new LinkedHashSet();
        books.add("张三丰");
        books.add("张丰益");
        books.add("李自成");
        System.out.println(books);
        books.remove("张丰益");
        books.add("张益达");
        //可见 张丰益 跑set的最后面了。提现了插入的有序性
        System.out.println(books);
    }
}
