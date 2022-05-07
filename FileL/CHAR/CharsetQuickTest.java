package FileL.CHAR;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CharsetQuickTest {
    public static void main(String[] args) {
        Charset cn = Charset.forName("UTF-8");
        ByteBuffer bbuf = cn.encode("孙子兵法");
        System.out.println(bbuf);

        CharBuffer cbuf = cn.decode(bbuf);
        System.out.println(cbuf);

        ByteBuffer bbuf2 = cn.encode(cbuf);
        System.out.println(bbuf2);

        //返回字符串的字节数组，注意不是ByteBuffer
        var byteArr = "孙子兵法".getBytes(StandardCharsets.UTF_8);
        System.out.println(byteArr);
        //当然我们可以遍历这个数组然后给他写入到一个ByteBuffer是没问题的
        //声明一个ByteBuffer 容量就是数组长度，防止装不下
        ByteBuffer bb = ByteBuffer.allocate(byteArr.length);
        for (int i = 0; i < byteArr.length; i++) {
            System.out.println(byteArr[i]);
            bb.put(byteArr[i]);
        }
        bb.flip();
        //字节->字符 decode一下搞定
        System.out.println(cn.decode(bb));

        //当然：byte数组->字符串也是OK的，比上面的还简单呢
        System.out.println(new String(byteArr));

    }
}
