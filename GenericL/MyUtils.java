package GenericL;

import java.util.ArrayList;
import java.util.Collection;

public class MyUtils {
    //下面dest集合元素的类型必须和src集合元素的类型相同，或者是其的父类
    public static <T> T copy(Collection<? super T> dest, Collection<T> src) {
        T last = null;
        for (var ele : src) {
            //利用逆变
            last = ele;

            dest.add(last);
        }
        return last;
    }

    public static void main(String[] args) {
        //dest 类型是 src的父类
        var desc = new ArrayList<Number>();
        // src
        var src = new ArrayList<Integer>();
        src.add(1);
        src.add(3);
        Integer last = copy(desc, src);
        System.out.println(last);
        System.out.println(desc);
    }
}
