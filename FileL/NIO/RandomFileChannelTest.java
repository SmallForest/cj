package FileL.NIO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//注意这个代码在M1芯片的电脑上运行会卡死，请使用docker环境运行测试
public class RandomFileChannelTest {
    public static void main(String[] args) throws IOException {
        var f = new File("a.txt");
        try (
                var raf = new RandomAccessFile(f, "rw");
                //获取对应Channel
                FileChannel randomChannel = raf.getChannel();
        ) {
            ByteBuffer buffer = randomChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
            //将position指针移动到最后
            randomChannel.position(f.length());
            //copy一份a.txt数据追加到a.txt后面
            randomChannel.write(buffer);
        }
    }
}
