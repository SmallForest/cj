package FileL;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class AppendContent {
    public static void main(String[] args) {
        try (
                var raf = new RandomAccessFile("out.txt", "rw");
        ) {
            //将seek到文件末尾
            raf.seek(raf.length());
            //末尾写入 即实现文件追加内容
            raf.write("append zero\r\n".getBytes(StandardCharsets.UTF_8));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            //测完删除
            new File("out.txt").deleteOnExit();
        }
    }
}
