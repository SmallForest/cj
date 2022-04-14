package collectionL;

import java.util.stream.IntStream;

public class IntStreamTest {
    public static void main(String[] args) {
        var is = IntStream.builder()
                .add(1)
                .add(2)
                .add(-3)
                .build();
        //下面的聚集方法每次只能执行一行。其他的要注释
        //System.out.println(is.max().getAsInt());
        //System.out.println(is.min().getAsInt());
        //求和
        //System.out.println(is.sum());
        //数量
        // System.out.println(is.count());
        //平均值
        //System.out.println(is.average());
        //是不是所有的元素的平方都大于20
        //System.out.println(is.allMatch(a->a*a>20));
        //是不是所有的元素的平方都小于20
        //System.out.println(is.allMatch(a->a*a<20));
        //将is映射生成新Stream
        var newIs = is.map(a -> a * 2 + 1);
        //newIs.forEach(a-> System.out.println(a));
        newIs.forEach(System.out::println);
    }
}
