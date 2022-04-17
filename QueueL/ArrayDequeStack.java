package QueueL;

import java.util.ArrayDeque;

public class ArrayDequeStack {
    public static void main(String[] args) {
        var stack = new ArrayDeque();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack);
        //只读取不出栈
        System.out.println(stack.peek());
        System.out.println(stack);
        //出栈
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
