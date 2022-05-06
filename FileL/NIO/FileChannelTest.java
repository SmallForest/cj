package FileL.NIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelTest {
    public static void main(String[] args) {
        File f = new File("FileL/NIO/FileChannelTest.java");
        try (
                var inChannel = new FileInputStream(f).getChannel();
                var outChannel = new FileOutputStream("a.txt").getChannel()
        ) {
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0,
                    f.length());

            outChannel.write(buffer);
            buffer.clear();

            //1 使用UTF-8解码(因为我的编辑器设置的编码是UTF-8)
            Charset charset = Charset.forName("UTF-8");
            //2 创建解码器
            CharsetDecoder decoder = charset.newDecoder();
            //3 将ByteBuffer -> CharBuffer
            CharBuffer charBuffer = decoder.decode(buffer);
            System.out.println(charBuffer);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            new File("a.txt").deleteOnExit();
        }
    }
}
