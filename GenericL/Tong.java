package GenericL;

import java.util.List;

public class Tong {
    //提出提示泛型警告，"参数化类 'List' 的原始使用 "
    public void test(List c){
        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i));
        }
    }
    public static void main(String[] args) {

    }
}
