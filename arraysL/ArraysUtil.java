package arraysL;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class ArraysUtil {
    public static void main(String[] args) {
        var arr = new int[]{14, 11, 12, 3, 4, 5, 6, 9};
        //使用二分法查找之前，需要先排序。使用的排序是快速排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        //二分法查找
        var pos = Arrays.binarySearch(arr, 12);
        System.out.println("12的位置 " + pos);

        var arr1 = new int[]{1, 2, 3};
        var arr2 = new int[]{1, 2, 3};
        //arr1=arr2返回0，如果参数1大返回正数，参数1小返回负数
        var c = Arrays.compare(arr1, arr2);
        System.out.println(c);

        //相等 得到true表示 arr1 arr2内容相同。
        System.out.println("arr1 equal arr2？" + Arrays.equals(arr1, arr2));
        //== 得到false 表示 arr1 arr2不是一个对象。这就是区别
        System.out.println("arr1==arr2？" + (arr1 == arr2));

        //声明arr3 并未初始化
        int[] arr3;
        //复制数组2给数组3，在StringBuffer StringBuilder扩容的时候也是调用的这个方法 3是我主动"扩容"的空间
        arr3 = Arrays.copyOf(arr2, arr2.length + 3);
        System.out.println("拷贝后的arr3" + Arrays.toString(arr3));
        //copyOfRange 很一般 就是指定了范围。
        //deepEquals 如果两个指定的数组彼此深度相等，则返回 true。

        //对arr3执行fill（填写）将数组的每个元素都干成 29 了。。。。。
        Arrays.fill(arr3, 29);
        System.out.println("fill后的arr3" + Arrays.toString(arr3));
        //当然为了解决这个问题，fill还有个重载方法， fill(int[] a, int fromIndex, int toIndex, int val) 参数 2 3可以指定开始和结束下标。知道有这个方法就行了。

        //获取arr3的hashCode
        System.out.println("arr3的hashCode：" + Arrays.hashCode(arr3));
        //这个应该和上面的是一样的 但是不一样。。。不一样的原因是Arrays重定义了hashCode()算法;算法看源码就行了
        //Arrays重写之后只要数组内容一样 hashCode就一样
        System.out.println("arr3调用实例方法：" + arr3.hashCode());
        //真实hashCode
        System.out.println("arr3的identityHashCode：" + System.identityHashCode(arr3));

        //Arrays重写之后只要数组内容一样 hashCode就一样
        var arr4 = new int[]{1, 2, 3};
        var arr5 = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.hashCode(arr4));
        System.out.println(Arrays.hashCode(arr5));

        //返回arr4 arr5第一个不匹配的索引
        System.out.println("arr4 arr5第一个不匹配的索引：" + Arrays.mismatch(arr4, arr5));


        //parallelPrefix 数组按照第二个参数的规则进行运算，其中left表示第一个运算符，right表示第二个运算符。请参考IntBinaryOperator源码
        //当然也就是模板模式-设计模式之一
        Arrays.parallelPrefix(arr5, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });
        System.out.println(Arrays.toString(arr5));
        //同样的静态方法，第二个参数使用lambda表达式
        Arrays.parallelPrefix(arr5, (a, b) -> a + b);
        System.out.println(Arrays.toString(arr5));

        //	parallelSetAll （parallel并发）单个处理数组中的每个元素,参数是下标。原理和上面的类似
        var arr6 = new int[]{1, 2, 3, 4, 5, 6};
        Arrays.parallelSetAll(arr6, new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                System.out.println(operand);
                return arr6[operand] * 2;
            }
        });
        System.out.println(Arrays.toString(arr6));
        Arrays.parallelSetAll(arr6, a -> arr6[a] * 2);
        System.out.println(Arrays.toString(arr6));

        System.out.println("arr7");
        var arr7 = new int[]{6, 5, 4, 3, 2, 1};
        //将指定的数组按数字升序排序
        Arrays.parallelSort(arr7);
        System.out.println(Arrays.toString(arr7));

        //setAll 和 parallelSetAll功能相同，只不过不是并发执行而已！
        System.out.println("arr7 setAll");
        //a是索引
        Arrays.setAll(arr7, a -> arr7[a] * 2);
        System.out.println(Arrays.toString(arr7));

        // Arrays现在有两个我不大明白用法，spliterator() 迭代分割器，stream()在线流 这个是更高级的用法吗？是不是我先记着随后学到List就可以明白了
        //迭代分割器 spliterator？？？TODO 需要咨询
        var s = Arrays.spliterator(arr7, 1, 3);
        //stream todo 不了解 应该是流
        //toString() 常用！返回指定数组内容的字符串表示形式。上面已经用到不再演示

        //parallelPrefix计算数组累加和
        var arr8 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        var arr9 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.parallelPrefix(arr8, (a, b) -> a + b);
        System.out.println(Arrays.toString(arr8));
        System.out.println("arr8：" + arr8[arr8.length - 1]);
        //两种方式，第二种是单线程遍历效率低。上面的效率就很高了
        var sum = 0;
        for (int i = 0; i < arr8.length; i++) {
            sum += arr9[i];
        }
        System.out.println("arr9：" + sum);

    }
}
