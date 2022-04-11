package CloneL;

import java.util.Objects;

public class ObjectTest {
    //obj是null
    static ObjectTest obj;

    public static void main(String[] args) {
        //0
        System.out.println(Objects.hashCode(obj));
        //
        System.out.println(Objects.toString(obj));
        //入参校验 ，对象不可null null爆异常
        System.out.println(Objects.requireNonNull(obj,"obj参数不可为null"));
    }
}
