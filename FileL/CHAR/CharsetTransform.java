package FileL.CHAR;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CharsetTransform {
    public static void main(String[] args) throws CharacterCodingException {
        //step1 创建Charset
        Charset cn = Charset.forName("UTF-8");
        //step2 获取cn对象的编码器 解码器
        CharsetDecoder cnDecoder = cn.newDecoder();
        CharsetEncoder cnEncoder = cn.newEncoder();

        //创建 CharBuffer
        CharBuffer cbuf = CharBuffer.allocate(8);
        cbuf.put('孙');
        cbuf.put('子');
        cbuf.put('兵');
        cbuf.put('法');
        //切换读模式
        cbuf.flip();
        //将字符序列修改成字节序列
        //step3 编码器调用
        ByteBuffer bbuf = cnEncoder.encode(cbuf);
        //循环访问bbuf中每个字节
        for (int i = 0; i < bbuf.limit(); i++) {
            System.out.print(bbuf.get(i)+" ");
        }
        //step3 调用解码器将ByteBuffer数据解码成字符
        System.out.println(cnDecoder.decode(bbuf));
    }
}
