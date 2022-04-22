package GenericL;

import java.util.ArrayList;
import java.util.List;

public class Tone2 {
    //List元素都是Object，使用Object限制。看着是没问题的，实际是有问题的
    public void test(List<Object> c){
        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i));
        }
    }
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        //将 strList当做参数
        var t2 = new Tone2();
        //这句话是会报错的，表明List<String>不能当做List<Object>使用，也就是说
        //List<String>并不是List<Object>子类
        //t2.test(strList);
    }
}
