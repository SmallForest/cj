package GenericL;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericMethod {
    //只能将src数组元素是Object类型的放入集合，元素值Object子类的并不行
    static void fromArrayToCollection(Object[] src, Collection<Object> c){
        for (var o:src) {
            c.add(o);
        }
    }
    public static void main(String[] args) {
        String[] strArr = {"a","b"};
        //此处只能是List<Object>,下面写法爆错
        //List<String> strList = new ArrayList<>();
        //fromArrayToCollection(strArr,strList);
        //System.out.println(strList);
        //使用通配符不行，因为带有通配符的c.add(o)插入是不行的


    }
}
