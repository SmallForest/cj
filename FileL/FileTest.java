package FileL;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {
        //以当前路径创建一个File对象
        var file = new File(".");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsoluteFile());


        //获取相对路径的父路径 null
        System.out.println(file.getParent());

        //获取绝对路径
        System.out.println(file.getAbsoluteFile());
        //上一级
        System.out.println(file.getAbsoluteFile().getParent());

        //创建一个临时文件
        File tmpFile = File.createTempFile("aaa", ".txt", file);
        //jvm退出 删除文件
        tmpFile.deleteOnExit();
        //毫秒级时间戳当做参数
        var newFile = new File(System.currentTimeMillis() + "");
        System.out.println("newFile对象是否存在" + newFile.exists());
        //以指定newFile对象来创建一个文件
        newFile.createNewFile();
        //jvm退出删除
        newFile.deleteOnExit();

        //以newFile对象来创建一个目录，因为newFile文件已经存在，目录就不能创建了
        //下面方法返回false 无法创建该目录
        System.out.println(newFile.mkdir());

        //使用list() 方法列出当前路径下所有文件和路径
        String[] fileList =file.list();
        System.out.println("==当前路径下所有文件和路径如下==");
        for (var fileName:fileList
             ) {
            System.out.println(fileName);
        }
        //listRoots()静态方法列出所有的磁盘根路径
        File[] roots = File.listRoots();
        System.out.println("==系统所有根路径如下==");
        for (var root:roots
             ) {
            System.out.println(root);
        }

        var file1 = new File("a.ini");
        //返回字节数量
        System.out.println(file1.length());

        var file2 = new File("ys.log");
        file2.createNewFile();
        file2.delete();

        var file3 = new File("FileL");
        var file4 = File.createTempFile("ysn",".log",file3);
        //jvm退出 删除文件
        file4.deleteOnExit();

        var file5= new File("FileL/ys");
        file5.mkdir();
        //jvm退出 删除文件
        file5.deleteOnExit();
    }
}
