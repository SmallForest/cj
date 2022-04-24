package GenericL;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ErrorTest2 {
    //要求from的类型比to的类型小，比如form是Integer,to可以使用Integer、Number、Object等
    static <T> void test(Collection<? extends T> from, Collection<T> to) {
        for (var ele : from
        ) {
            to.add(ele);
        }
    }

    public static void main(String[] args) {
        List<Object> ao = new ArrayList<>();
        List<String> as = new ArrayList<>();
        as.add("a");
        as.add("b");
        as.add("c");
        test(as, ao);
        System.out.println(ao);
        //这是错误的，因为from Object ,to String。from>to的类型
        //test(ao,as);

        ao.forEach(a -> System.out.println(((String) a).length()));

    }
}