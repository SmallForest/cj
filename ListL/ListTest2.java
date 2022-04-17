package ListL;

import java.util.ArrayList;

class A {
    public boolean equals(Object obj) {
        return true;
    }
}

public class ListTest2 {
    public static void main(String[] args) {
        var books = new ArrayList();
        books.add("a");
        books.add("b");
        books.add("c");
        System.out.println(books);
        //参数对象和List的进行 (new A()).equals("a")==true 程序认为是同一个元素，直接删除
        books.remove(new A());
        System.out.println(books);
        //这次删除 b
        books.remove(new A());
        System.out.println(books);
    }
}
