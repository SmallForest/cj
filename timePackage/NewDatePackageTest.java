package timePackage;

import java.time.*;

public class NewDatePackageTest {
    public static void main(String[] args) {
        //获取当前Clock
        Clock clock = Clock.systemUTC();
        //UTC https://baike.baidu.com/item/%E5%8D%8F%E8%B0%83%E4%B8%96%E7%95%8C%E6%97%B6/787659?fromtitle=UTC&fromid=5899996&fr=aladdin
        //获取当前时刻
        System.out.println("当前时刻为：" + clock.instant());
        //获取对应毫秒数，毫秒级时间戳
        System.out.println(clock.millis());
        System.out.println(System.currentTimeMillis());

        //关于Duration
        var d = Duration.ofSeconds(6000);
        //并不准，都是整数
        System.out.println("6000s相当于" + d.toMinutes() + "分");
        System.out.println("6000s相当于" + d.toHours() + "小时");
        System.out.println("6000s相当于" + d.toDays() + "天");

        //在clock基础上增加6000秒，返回新 Clock对象
        var clock2 = Clock.offset(clock, d);
        //clock2 clock相差6000s 100分钟 1小时40分钟
        System.out.println("clock2的当前时刻" + clock2.instant());

        //关于Instant用法
        //获取当前时间
        var instant = Instant.now();
        System.out.println(instant);
        //为instant添加6000秒 返回新的Instant
        var instant2 = instant.plusSeconds(6000);
        System.out.println(instant2);

        //根据字符串解析生成Instant对象
        var instant3 = Instant.parse("2014-02-23T10:12:35.342Z");
        System.out.println(instant3);

        //在instant3基础上增加5小时4分钟
        var instant4 = instant3.plus(Duration.ofHours(5).plusMinutes(4));
        System.out.println(instant4);

        //获取instant4在五天前的时刻
        var instant5 = instant4.minus(Duration.ofDays(5));
        System.out.println(instant5);

        //LocalDate
        var localDate = LocalDate.now();
        System.out.println(localDate);

        //获取2014年的第146天
        localDate = LocalDate.ofYearDay(2014, 146);
        System.out.println(localDate);
        //设置为2014年5月21日
        localDate = LocalDate.of(2014, Month.MAY, 21);
        System.out.println(localDate);

        //LocalTime用法
        //获取当前时间
        var localTime = LocalTime.now();
        System.out.println(localTime);
        //设置为22点33分
        localTime = LocalTime.of(22, 33);
        System.out.println(localTime);
        //返回一天中的第5503秒
        localTime = LocalTime.ofSecondOfDay(5503);
        System.out.println(localTime);

        //关于LocalDateTime的用法
        var localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        //当前日期 时间上增加25小时 3分钟
        var future = localDateTime.plusHours(25).plusMinutes(3);
        System.out.println(future);

        //关于Year YearMonth MonthDay用法示例
        var year = Year.now();
        System.out.println("当年年份" + year);
        year = year.plusYears(5);
        System.out.println("5年后" + year);

        //指定月份 获取YearMonth
        var ym = year.atMonth(10);
        System.out.println("year年的10月：" + ym);
        //当前年月再加5年，减少3个月
        ym = ym.plusYears(5).minusMonths(3);
        System.out.println(ym);
        var md = MonthDay.now();
        System.out.println("当前年月"+md);
        //设置为5月23日
        var md2 = md.with(Month.MAY).withDayOfMonth(23);
        System.out.println(md2);


    }
}
