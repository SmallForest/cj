package CollectionsL;

import java.util.Collections;
import java.util.HashMap;

public class UnmodifiableTest {
    public static void main(String[] args) {
        //空 不可改变的List对象
        var unmodifiableList= Collections.emptyList();
        //创建只有一个元素的 Set对象
        var unmodifiableSet = Collections.singleton("abc");
        //创建普通Map对象
        var scores = new HashMap();
        scores.put("数学",100);
        scores.put("语文",100);
        var unmodifiableMap = Collections.unmodifiableMap(scores);
        //下面代码都是错误的
        unmodifiableList.add("a");
        unmodifiableSet.add("a");
        unmodifiableMap.put("历史",50);

    }
}
