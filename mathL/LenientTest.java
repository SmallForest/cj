package mathL;

import java.util.Calendar;

public class LenientTest {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        //年+1 因为月设置了13，月的值=1（表示2月）
        cal.set(Calendar.MONTH, 13);
        System.out.println(cal.getTime());
        //关闭容错 意思就是：参数必须对，错了就爆错！
        cal.setLenient(false);
        cal.set(Calendar.MONTH, 13);
        System.out.println(cal.getTime());

    }
}
