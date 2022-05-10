package FileL.CHAR;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesTest {
    public static void main(String[] args) throws Exception {
        var filename = "FileL/CHAR/FilesTest.java";
        //复制文件
        Files.copy(Paths.get(filename), new FileOutputStream("a.txt"));
        //判断文件是否是隐藏文件
        System.out.println(Files.isHidden(Paths.get(filename)));
        //一次性读取文件所有行
        List<String> lines = Files.readAllLines(Paths.get(filename), Charset.forName("utf-8"));
        System.out.println(lines);

        //判断文件大小 单位字节
        System.out.println(Files.size(Paths.get(filename)));

        //写入文件
        List<String> poem = new ArrayList<>();
        poem.add("123");
        poem.add("456");
        Files.write(Paths.get("a.txt"),poem,Charset.forName("utf-8"));
        //列出当前目录下所有文件 子目录
        Files.list(Paths.get(".")).forEach(path -> System.out.println(path));
        //读取文件内容
        Files.lines(Paths.get(filename),Charset.forName("utf-8")).forEach(line-> System.out.println(line));
    }
}
