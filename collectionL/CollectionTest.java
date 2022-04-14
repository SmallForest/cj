package collectionL;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("孙悟空");
        c.add(6);
        System.out.println("c集合的元素个数：" + c.size());
        //删除指定元素
        c.remove(6);
        System.out.println(Arrays.toString(c.toArray()));
        //判断是否包含指定字符串？
        System.out.println("包含熏悟空吗？" + c.contains("熏悟空"));
        System.out.println("包含孙悟空吗？" + c.contains("孙悟空"));
        c.add("abc");
        // 和这个效果相同 System.out.println(Arrays.toString(c.toArray()));
        System.out.println("c集合的元素" + c);

        //具体到 3个实现之一 的 Set 无序集
        Collection books = new HashSet();
        books.add("abc");
        books.add("abc第二部");
        System.out.println("书籍有：" + books);
        System.out.println("c集合是否包含books集合" + c.containsAll(books));

        //c集合减去books集合
        c.removeAll(books);
        // abc abc重名 被减去了
        System.out.println("减去之后的c集合" + c);
        //清空集合c
        c.clear();
        System.out.println("清空c之后的元素个数" + c.size());
        //c空了，retainAll从集合中删除集合c里不包含的元素。求交集
        books.retainAll(c);
        //交集空
        System.out.println(books);


        //该Collection使用了泛型（随后学），指定它的集合元素都是String
        var strColl = List.of("java", "php", "golang");
        //toArray()方法的参数是一个Lambda表达式，代表IntFunction对象？
        //此时toArray()方法的返回值类型是String[]，而不是Object[]数组
        String[] sa = strColl.toArray(String[]::new);
        System.out.println(Arrays.toString(sa));
    }
}
