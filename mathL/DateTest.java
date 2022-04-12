package mathL;

import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        var d1 = new Date();
        //获取当前时间100ms的时间
        var d2 = new Date(System.currentTimeMillis()+100);
        System.out.println(d2);
        System.out.println(d1.before(d2));
        System.out.println(d1.after(d2));
        System.out.println(d1.compareTo(d2));
        //毫秒级时间戳
        System.out.println(d1.getTime());
    }
}
