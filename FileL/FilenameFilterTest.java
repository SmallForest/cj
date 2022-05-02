package FileL;

import java.io.File;

public class FilenameFilterTest {
    public static void main(String[] args) {
        var file = new File("FileL");
        //d=dir n=name 列举出.java后缀和文件夹
        String[] nameList = file.list((d, n) -> n.endsWith(".java") || new File(n).isDirectory());
        for (var name : nameList) {
            System.out.println(name);
        }
    }
}
