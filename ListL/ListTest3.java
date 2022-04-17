package ListL;

import java.util.ArrayList;

public class ListTest3 {
    public static void main(String[] args) {
        var books = new ArrayList();
        books.add("a11");
        books.add("b22");
        books.add("c333");
        //按照字符串长度 倒序
        books.sort((a, b) -> {
            var o1 = ((String) a).length();
            var o2 = ((String) b).length();
            if (o1 == o2) return 0;
            if (o1 > o2) return -1;
            return 1;
        });
        //按照字符串长度 倒序
        System.out.println(books);

        //按照字符串长度填充 books
        books.replaceAll(a->((String)a).length());
        System.out.println(books);
    }
}
