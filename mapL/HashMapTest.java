package mapL;

import java.util.HashMap;

class AA{
    int count;
    public AA(int count){
        this.count = count;
    }
    //根据count的值判断两个对象是否相等
    public boolean equals(Object obj){
        if (obj==this)
            return true;
        if (obj!=null && obj.getClass()==AA.class){
            var a = (AA)obj;
            return this.count == a.count;
        }
        return false;
    }

    //根据count计算hashCode值
    public int hashCode(){
        return count;
    }

    @Override
    public String toString() {
        return "A{" +
                "count=" + count +
                '}';
    }
}
class BB{
    //重写equals()，B的实例和任何对象比较都相等
    public boolean equals(Object obj){
        return true;
    }
}

public class HashMapTest {
    public static void main(String[] args) {
        var hm = new HashMap();
        //设置k-v
        hm.put(new AA(60000),"a");
        hm.put(new AA(87563),"a");
        hm.put(new AA(1232),new BB());
        System.out.println(hm);
        //HashMap相等
        System.out.println(hm.containsValue(new BB()));
        //HashMap不相等
        System.out.println(hm.containsValue("xx"));
        //判断key是否存在，重写了new A()的 equals() hashCode()
        //不然不会相等，目前只要count相等，两个A的实例就相等
        System.out.println(hm.containsKey(new AA(87563)));
        //尝试删除
        hm.remove(new AA(1232));
        System.out.println(hm);
    }
}
