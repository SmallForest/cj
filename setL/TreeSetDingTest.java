package setL;

import java.util.TreeSet;

class M {
    int age;

    public M(int age) {
        this.age = age;
    }

    public String toString() {
        return "M[age:" + age + "]";
    }
}

public class TreeSetDingTest {
    public static void main(String[] args) {
        var ts = new TreeSet((a, b) -> {
            var m1 = (M) a;
            var m2 = (M) b;
            if (m1.age == m2.age) {
                return 0;
            } else if (m1.age > m2.age) {
                //m1比m2的age大的时候，让m1靠左，也就是认为m1比m2小，这就是按照年龄由大到小
                return -1;
            } else {
                return 1;
            }
        });
        ts.add(new M(5));
        ts.add(new M(-3));
        ts.add(new M(9));
        System.out.println(ts);
    }
}
