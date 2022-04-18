package mapL;

import java.util.HashMap;

public class MapTest2 {
    public static void main(String[] args) {
        var map = new HashMap();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", null);
        //使用compute模拟三种情况
        //1 new value != null,new value直接覆盖旧value的情况
        //就像 下面例子返回值是199 并不是null，因此b的值修改成199
        map.compute("b", (k, v) -> 199);
        //这个例子中c对应的旧value是null,新value不是null，因此c变成了1
        map.compute("c", (k, v) -> 1);
        System.out.println(map);

        //为了模拟2 将c从新置为null
        map.put("c", null);
        System.out.println(map);


        //2 旧value不是null，但是新value是null，直接删除
        map.compute("b", (k, v) -> null);
        System.out.println(map);

        //为了模拟3 将b从新置为2
        map.put("b", 2);
        System.out.println(map);

        System.out.println(map.get("c")==null);
        //3(坑) 旧value是null 新value也是null。什么也不做(这里的旧值不存在，只能是key在map不存在，才会什么也不做，如果k存在且对应的v是null，则会删除)
        //这里成c值是null，get("c")结果是null，但不会触发什么也不做，会删除c
        var r = map.compute("c", (k, v) -> null);
        System.out.println("key=c存在时,值是null时:"+r);

        //key cc根本不存在才会触发什么也不做
        r = map.compute("cc", (k, v) -> null);
        System.out.println("key=cc存在时,值是不存在时:"+r);
        System.out.println(map);
        //其实不是坑，只要返回null就会删除，文档中提到了

        //以上的特点看文档 可以知道一二 https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Map.html#compute(K,java.util.function.BiFunction)
    }
}
