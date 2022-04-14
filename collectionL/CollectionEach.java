package collectionL;

import java.util.HashSet;
import java.util.function.Consumer;

public class CollectionEach {
    public static void main(String[] args) {
        //创建一个集合
        var books = new HashSet();
        //添加元素 3个
        books.add("abc");
        books.add("d");
        books.add("efg");
        //lambda表达式 遍历元素 ()->{}
        books.forEach(a -> System.out.println(a));

        //不推荐，仅用对比
        books.forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });
    }
}
