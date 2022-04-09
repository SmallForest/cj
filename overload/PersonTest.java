package overload;

public class PersonTest {
    public static void main(String[] args) {
        var p =new Person();
        p.setAge(100);
        System.out.println(p.getAge());
        p.setName("lihua");
        System.out.println(p.getName());

    }
}
