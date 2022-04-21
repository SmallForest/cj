package CollectionsL;

import java.util.ArrayList;
import java.util.Collections;

public class SearchL {
    public static void main(String[] args) {
        //声明list
        var l = new ArrayList<String>();
        l.add("a");
        l.add("b");
        l.add("d");
        l.add("c");
        //不能有null
        //l.add(null);
        //排序
        Collections.sort(l);
        //按照ASCII码 小-大
        System.out.println(l);
        //查找
        System.out.println(Collections.binarySearch(l,"l"));
        System.out.println(Collections.binarySearch(l,"a"));

        //替换所有
        Collections.fill(l,"hh");
        System.out.println(l);
        //统计次数
        System.out.println(Collections.frequency(l,"hh"));

        l.clear();
        l.add("a");
        l.add("b");
        l.add("c");
        l.add("d");
        l.add("c");
        l.add("d");
        System.out.println(l);
        var l2 = new ArrayList<String>();
        l2.add("c");
        l2.add("d");
        System.out.println(l2);
        System.out.println("首次位置："+Collections.indexOfSubList(l,l2));

        //替换全部的旧值
        Collections.replaceAll(l,"d","dnf");
        System.out.println(l);

    }
}
