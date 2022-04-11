package CloneL;

public class StringBufferTest {
    public static void main(String[] args) {
        var sb = new StringBuffer();
        sb.append("java");
        sb.insert(0, "hello ");
        System.out.println(sb.toString());

        sb.replace(5, 6, ",");
        System.out.println(sb);
        sb.delete(5, 6);

        sb.reverse();
        System.out.println(sb);
        //字符串长度
        System.out.println(sb.length());
        //byte[]数组长度，或者叫容量
        System.out.println(sb.capacity());
        //截断字符串
        sb.setLength(5);
        System.out.println(sb);
        //增加长度10，补充了5个特殊字符串，后面追加了一个数字1
        sb.setLength(10);
        sb.append(1);
        System.out.println(sb);
    }
}
