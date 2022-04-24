package GenericL;

import java.util.ArrayList;
import java.util.Collection;

public class GenericMethod2 {
    //此例子中要求T要一致，编译器方便推断类型，如果不一致则不容易推断类型
    static <T> void fromArrayToCollection(T[] a, Collection<T> c){
        for(T o:a){
            c.add(o);
        }
    }

    public static void main(String[] args) {
        var oa = new Object[10];
        Collection<Object> co = new ArrayList<>();
        //下面代码中T代表Object类型
        fromArrayToCollection(oa,co);
        System.out.println(co);

        var sa = new String[10];
        Collection<String> cs = new ArrayList<>();
        //下面的T代表String类型
        fromArrayToCollection(sa,cs);
        System.out.println(cs);
    }
}
