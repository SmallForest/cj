package GenericL;

import java.util.ArrayList;
import java.util.List;

public class Tong3 {
    //List<?> 通配符，它的元素类型可以匹配任何类型
    public void test(List<?> c){
        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i));
        }
    }
    public static void main(String[] args) {
        List<?> c = new ArrayList<String>();
        //下面程序编译报错
        //c.add(new Object())
    }
}
