package setL;

import java.util.HashSet;

class A{
    public boolean equals(Object obj){
        return true;
    }
}
class B{
    public int hashCode(){
        return 1;
    }
}
class C{
    public int hashCode(){
        return 2;
    }
    public boolean equals(Object obj){
        return true;
    }
}
public class HashSetTest {
    public static void main(String[] args) {
        //声明一个set
        var books = new HashSet();
        //连续添加A对象，其中hashCode不相等，equals()相等。认为是不同的元素
        books.add(new A());
        books.add(new A());

        //连续添加两个B对象，hashCode相等，equals()不相等。认为是不同的元素
        books.add(new B());
        books.add(new B());

        //连续添加两个B对象，hashCode相等，equals()相等。认为是同一个元素，相同元素set中只可以存在一个
        books.add(new C());
        books.add(new C());


        System.out.println(books);
    }
}
