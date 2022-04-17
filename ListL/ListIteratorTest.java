package ListL;

import java.util.ArrayList;

public class ListIteratorTest {
    public static void main(String[] args) {
        String[] books  = {"a","b","c"};
        var bookList = new ArrayList();
        for (int i = 0; i < books.length; i++) {
            bookList.add(books[i]);
        }
        var lit = bookList.listIterator();
        //从前往后
        while (lit.hasNext()){
            System.out.println(lit.next());
        }
        System.out.println("---------");
        //从后往前
        while (lit.hasPrevious()){
            System.out.println(lit.previous());
        }
    }
}
