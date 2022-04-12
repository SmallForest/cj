package mathL;

import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
        var c = Calendar.getInstance();
        //取出年
        System.out.println(c.get(Calendar.YEAR));
        //月比实际月小1
        System.out.println(c.get(Calendar.MONTH));
        System.out.println(c.get(Calendar.DATE));//日
        c.set(2003,10,23,12,32,12);
        System.out.println(c.getTime());
        //年减一
        c.add(Calendar.YEAR,-1);
        System.out.println(c.getTime());
    }
}
