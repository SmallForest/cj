package QueueL;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        var books = new LinkedList();
        //将元素加入队列尾部
        books.offer("a");
        //将元素压入栈顶
        books.push("b");
        //将元素添加到队列首部（相等于压入栈顶）
        books.offerFirst("c");
        //使用List方式 ，按照索引访问
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
        //访问不删除
        System.out.println(books.peekFirst());
        System.out.println(books.peekLast());
        System.out.println(books.pop());
        System.out.println(books);

        System.out.println(books.pollLast());
        System.out.println(books);

    }
}
