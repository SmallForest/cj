package mathL;

import java.util.Calendar;

public class LazyTest {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        //2003-8-31 month7=8月
        cal.set(2003,7,31);
        //月份设置为9月 但是9月并没有31号
        cal.set(Calendar.MONTH,8);
        //输出10.1日期进1 通过是否注释这一行表现出延迟的特性，不注释的情况下变成10月5日，注释的情况下变成9月5日
        //System.out.println(cal.getTime());
        //日设置5日 变成10月5日 或者 9月5日
        cal.set(Calendar.DATE,5);
        System.out.println(cal.getTime());
    }
}
