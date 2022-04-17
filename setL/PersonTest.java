package setL;

import java.util.HashSet;

class Person{
    public String name;
    //构造器
    public Person(String name){
        this.name = name;
    }
    //重写hashCode 名字长度相同的hashCode是相同的。自定义的
    public int hashCode(){
        return name.length();
    }
    //重写equals
    public boolean equals(Object obj){
        //obj和this是同一个对象返回true
        if (this==obj)return true;
        if(obj!=null && obj.getClass()==Person.class){
            return name==((Person)obj).name;
        }
        return false;
    }
    //重写toString
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
public class PersonTest {
    public static void main(String[] args) {
        var s = new HashSet();
        System.out.println(s.add(new Person("李四")));//1
        System.out.println(s.add(new Person("李四")));//2
        System.out.println(s.add(new Person("张三")));//3
        //结果 2存不进集合s , 3 1存入同一个slot
        System.out.println(s);


        //获取集合中的第一个元素，可能是李四 也可能是张三。下面假设获取的是李四
        var it = s.iterator();
        //假设获取的是李四
        var p = (Person)it.next();
        System.out.println(p.name);
        //增加name长度，等于我们修改了其hashCode。李四厉害
        p.name = p.name+"厉害";
        System.out.println(s);

        //判断文件是否存在？
        //返回 false
        var e = s.contains(new Person("李四厉害"));
        System.out.println("李四厉害存在吗？"+e);
        //返回 false
        e = s.contains(new Person("李四"));
        System.out.println("李四存在吗？"+e);
        //出现上的原因是："李四厉害"的hashCode在s中不存在返回false。"李四"的hashCode存在，
        // 但是name值变成了"李四厉害"equals()方法返回false。所以两者都返回false。
        // 导致李四位置这个值读取不出来了
    }
}
