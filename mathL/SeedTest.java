package mathL;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SeedTest {
    public static void main(String[] args) {
        var r1 = new Random(50);
        System.out.println(r1.nextInt());
        System.out.println(r1.nextDouble());
        System.out.println(r1.nextFloat());
        System.out.println("-----------------");
        var r2 = new Random(50);
        System.out.println(r2.nextInt());
        System.out.println(r2.nextDouble());
        System.out.println(r2.nextFloat());
        System.out.println("-----------------");
        var r3 = new Random(150);
        System.out.println(r3.nextInt());
        System.out.println(r3.nextDouble());
        System.out.println(r3.nextFloat());

        //毫秒级时间戳
        var r4 = new Random(System.currentTimeMillis());
        System.out.println(r4.nextInt(12));

        //并发线程安全
        var r5 = ThreadLocalRandom.current();
        System.out.println(r5.nextInt(12));
    }
}
