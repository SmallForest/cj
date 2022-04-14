package collectionL;

import java.util.HashSet;

public class CollectionStream {
    public static void main(String[] args) {
        var books = new HashSet();
        books.add("abc");
        books.add("abcd");
        books.add("abcde");
        //优化 PredicateTest2 统计方式
        //统计名字包含a的数量
        //System.out.println(calAll(books, a -> ((String) a).contains("a")));
        System.out.println(books.stream().filter(a -> ((String) a).contains("a")).count());

        //长度大于4的数量
        //System.out.println(calAll(books, a -> ((String) a).length() > 4));
        System.out.println(books.stream().filter(a -> ((String) a).length() > 4).count());

        //先调用stream()方法，将集合转为Stream
        //再调用Stream的mapToInt()方法获取原有Stream的IntStream
        books.stream().mapToInt(a -> ((String) a).length()).forEach(System.out::println);
    }
}
