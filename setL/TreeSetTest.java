package setL;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        var s = new TreeSet();
        s.add(1);
        s.add(2);
        s.add(8);
        s.add(5);
        // 自然排序 null
        System.out.println(s.comparator());
        // 1
        System.out.println(s.first());
        // 8
        System.out.println(s.last());
        // 5
        System.out.println(s.lower(7));
        // 8
        System.out.println(s.higher(7));
        //子集 [1,3)
        System.out.println(s.subSet(1,3));
        System.out.println(s.headSet(7));
        System.out.println(s.tailSet(7));

        s=null;
        s = new TreeSet((a,b)->{
            var a1 = (int)a;
            var b1 = (int)b;
            if (a1==b1){
                return 0;
            }else if(a1>b1){
                return -1;
            }else {
                return 1;
            }
        });
        s.add(1);
        s.add(2);
        s.add(8);
        s.add(5);
        System.out.println("------------------");
        System.out.println(s);
        // 定制排序 降序
        System.out.println(s.comparator());
        // 1
        System.out.println(s.first());
        // 8
        System.out.println(s.last());
        // 5
        System.out.println(s.lower(7));
        // 8
        System.out.println(s.higher(7));
        //子集 [3,1)
        System.out.println(s.subSet(3,1));
        System.out.println(s.headSet(7));
        System.out.println(s.tailSet(7));
    }
}
