package oop;

public class Varargs {
    public static void test(int a,String... books)
    {
        for (String string : books) {
            System.out.println(string);
        }
        System.out.println(a);
    }
    public static void main(String[] args) {
        test(1, "西游记","红楼梦");
        test(1, new String[]{"三国演义","水浒传"});
    }
}
