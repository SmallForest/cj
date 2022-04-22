package GenericL;

import java.util.ArrayList;

public class GenericList {
    public static void main(String[] args) {
        //使用泛型，左侧决定右侧的类型，右侧可以使用菱形语法，即省略尖括号对中的类型声明
        //ArrayList<String> strList = new ArrayList<String>();
        //菱形语法应用 eg
        ArrayList<String> strList = new ArrayList<>();
        strList.add("a");
        //意外的保存了一个整数3,就会提示错误，保存不进去
        //strList.add(3);
        //强制类型转换就会报错
        strList.forEach(a-> System.out.println(a.length()));
    }
}
