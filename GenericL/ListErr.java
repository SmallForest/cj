package GenericL;

import java.util.ArrayList;

public class ListErr {
    public static void main(String[] args) {
        //目的是只保存字符串
        var strList = new ArrayList();
        strList.add("a");
        //意外的保存了一个整数3
        strList.add(3);
        //强制类型转换就会报错
        strList.forEach(a-> System.out.println(((String)a).length()));
    }
}
