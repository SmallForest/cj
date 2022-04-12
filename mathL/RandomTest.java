package mathL;

import java.util.Arrays;
import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        //未指定种子，使用默认种子。伪随机
        var rand = new Random();
        System.out.println("随机Boolean："+rand.nextBoolean());

        var buffer = new byte[16];
        rand.nextBytes(buffer);
        System.out.println(Arrays.toString(buffer));
        System.out.println(rand.nextDouble());
        System.out.println(rand.nextFloat());

        //伪高斯数
        System.out.println(rand.nextGaussian());

        System.out.println(rand.nextInt());
        //0-26
        System.out.println(rand.nextInt(26));
        System.out.println(rand.nextLong());

    }
}
