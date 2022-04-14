package collectionL;

import java.util.function.Predicate;
import java.util.Collection;
import java.util.HashSet;

public class PredicateTest2 {
    public static void main(String[] args) {
        var books = new HashSet();
        books.add("abc");
        books.add("abcd");
        books.add("abcde");
        //执行统计
        //统计名字包含a的数量
        System.out.println(calAll(books, a -> ((String) a).contains("a")));
        //d
        System.out.println(calAll(books, a -> ((String) a).contains("d")));
        //e
        System.out.println(calAll(books, a -> ((String) a).contains("e")));
        //长度大于4的数量
        System.out.println(calAll(books, a -> ((String) a).length() > 4));
    }

    public static int calAll(Collection books, Predicate p) {
        int s = 0;
        for (var obj : books) {
            //https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/function/Predicate.html
            //判断对象是否满足条件p，满足则++
            if (p.test(obj)) {
                s++;
            }
        }
        return s;
    }
}
