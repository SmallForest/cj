package GenericL;

public class Apple2<T extends Number> {
    T col;

    public static void main(String[] args) {
        Apple2<Integer> ai = new Apple2<>();
        Apple2<Double> ad = new Apple2<>();
        //下面会报错 java: 类型参数java.lang.String不在类型变量T的范围内
        //Apple2<String> as = new Apple2<>();
    }
}
