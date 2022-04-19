package mapL;

import java.util.Hashtable;

class A{
    int count;
    public A(int count){
        this.count = count;
    }
    //根据count的值判断两个对象是否相等
    public boolean equals(Object obj){
        if (obj==this)
            return true;
        if (obj!=null && obj.getClass()==A.class){
            var a = (A)obj;
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
class B{
    //重写equals()，B的实例和任何对象比较都相等
    public boolean equals(Object obj){
        return true;
    }
}
public class HashtableTest {
    public static void main(String[] args) {
        var ht = new Hashtable();
        //设置k-v
        ht.put(new A(60000),"a");
        ht.put(new A(87563),"a");
        ht.put(new A(1232),new B());
        System.out.println(ht);
        //由于存在value=new B() ，而该value的equals()被重写直接返回true
        //因此containsValue()均能命中该value，返回true
        System.out.println(ht.containsValue("xx"));
        //判断key是否存在，重写了new A()的 equals() hashCode()
        //不然不会相等，目前只要count相等，两个A的实例就相等
        System.out.println(ht.containsKey(new A(87563)));
        //尝试删除
        ht.remove(new A(1232));
        System.out.println(ht);
    }
}
