package arraysL;

public class deDynamic {
    public static void main(String[] args) {
        //定义数组
        int[] arr;
        //动态初始化 数组
        arr=new int[3];
        for (int i : arr) {
            System.out.println(i);
        }
        //定义+动态初始化 默认值0
        int[] arr1 = new int[4];
        //默认值null
        String[] books = new String[3];

        for (int i : arr1) {
            System.out.println(i);
        }
        for (String book : books) {
            System.out.println(book);
        }
        //使用var定义 静态初始化类型推断
        var names = new String[]{"赵四","王五"};
        for (var name : names) {
            System.out.println(name);
        }
        //使用var定义 动态初始化类型推断
        var ages = new int[3];
        for (int i : ages) {
            System.out.println(i);
        }
    }
}
