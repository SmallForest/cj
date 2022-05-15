package CloneL;

class Address {
    private String addr;

    public Address(String address) {
        addr = address;
    }

    public String getAddr() {
        return addr;
    }
}

// 1 实现Cloneable标记性接口，空接口，获取克隆能力
class User implements Cloneable {
    //定义私有变量
    private String name;
    public Address address;

    //构造器
    public User(String name) {
        this.name = name;
        this.address = new Address("济南市27-103");
    }

    //2 自定义clone方法
    public User clone() throws CloneNotSupportedException {
        // 3 调用父级clone()方法
        return (User) super.clone();
    }
}
public class cloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        var user1 = new User("李");
        var user2 = user1.clone();
        //false
        System.out.println("user1==user2？"+(user1==user2));
        //比较 address 是否相等？true
        System.out.println("address是否相等？"+(user1.address==user2.address));
    }
}
