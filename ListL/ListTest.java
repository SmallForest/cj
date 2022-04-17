package ListL;

import java.util.ArrayList;

public class ListTest {
    public static void main(String[] args) {
        var books = new ArrayList();
        books.add("a");
        books.add("b");
        books.add("c");
        System.out.println(books);
        books.add(1,new String("d"));
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
        System.out.println(books);
        books.remove(2);
        System.out.println(books);
        //判断c的位置
        System.out.println(books.indexOf(new String("c")));

        books.set(1,"e");
        System.out.println(books);
        //截取子集
        System.out.println(books.subList(0,1));
    }
}
