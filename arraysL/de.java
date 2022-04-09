package arraysL;

public class de {
    public static void main(String[] args) {
        //静态初始化 初始化时由程序员显示指定每个数组元素的初始值，由系统决定数组长度
        //定义一个int数组类型的变量，intArr .int数组
        int[] intArr;
        //静态初始化 指定元素初始值，不指定数组长度
        intArr = new int[] {4,5,6,7};

        //定义一个Object数组，objArr
        Object[] objArr;
        //存子类
        objArr = new String[] {"a","b"};

        Object[] objArr2;
        //存本类
        objArr2 = new Object[] {"c","d"};
        
        //为什么不能用foreach了？openjdk version "11.0.13" 2021-10-19
        for (int i : intArr) {
            System.out.println(i);
        }
        for (Object object : objArr) {
            System.out.println(object);
        }
        for (Object object : objArr2) {
            System.out.println(object);
        }

        //常用
        int[] arr = {1,2,3,4};
        for (int i : arr) {
            System.out.println(i);
        }

    }
}
