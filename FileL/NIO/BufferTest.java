package FileL.NIO;

import java.nio.IntBuffer;

public class BufferTest {
    public static void main(String[] args) {
        var intBuffer = IntBuffer.allocate(16);
        intBuffer.put(1);
        intBuffer.put(2);
        intBuffer.put(3);
        intBuffer.put(4);
        intBuffer.put(5);
        System.out.println("写模式");
        System.out.println("capacity "+intBuffer.capacity());
        System.out.println("position "+intBuffer.position());
        System.out.println("limit "+intBuffer.limit());
        intBuffer.flip();
        System.out.println("读模式");
        System.out.println("capacity "+intBuffer.capacity());
        System.out.println("position "+intBuffer.position());
        System.out.println("limit "+intBuffer.limit());
        System.out.println("clear()");
        intBuffer.clear();
        System.out.println("capacity "+intBuffer.capacity());
        System.out.println("position "+intBuffer.position());
        System.out.println("limit "+intBuffer.limit());
        //数据并未删除 get()会移动指针，get(int index)不会属于按照索引直接取值
        System.out.println(intBuffer.get(4));
    }
}
