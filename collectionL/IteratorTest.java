package collectionL;

import java.util.HashSet;

public class IteratorTest {
    public static void main(String[] args) {
        //创建一个集合
        var books = new HashSet();
        //添加元素 3个
        books.add("abc");
        books.add("d");
        books.add("efg");
        //获取一个迭代器iterator
        var it = books.iterator();
        while (it.hasNext()) {
            var book = (String) it.next();
            System.out.println(book);
            //尝试删除集合里的元素 会报错ConcurrentModificationException
            books.remove(book);
            //只能使用
            it.remove();
        }
    }
}
