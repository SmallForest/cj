package FileL.NIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        try (
                var fis = new FileInputStream("FileL/NIO/ReadFile.java");
                //创建一个channel
                FileChannel fcin = fis.getChannel()
                ){
            //定义ByteBuffer用于取数据
            ByteBuffer buffer = ByteBuffer.allocate(256);
            //将channel数据放入到buffer
            while (fcin.read(buffer)!=-1){
                //锁定buffer空白区，limit=position position=0 读数据做准备
                buffer.flip();
                //解码三部曲
                //1 使用UTF-8格式解码
                Charset charset = Charset.forName("UTF-8");
                //2 创建解码器
                CharsetDecoder decoder = charset.newDecoder();
                //3 将ByteBuffer->CharBuffer
                CharBuffer charBuffer = decoder.decode(buffer);
                //输出
                System.out.println(charBuffer);
                //将Buffer指针重置，为读数据做准备，不然新数据可写不进去
                buffer.clear();
            }
        }
    }
}
