package arraysL;

import java.util.Arrays;

//遍历数组
public class bl {
    public static void main(String[] args) {
        int[] ages = {1,2,3,4};
        for (int i = 0; i < ages.length; i++) {
            System.out.println(i);
        }
        for (int i : ages) {
            System.out.println(i);
        }
        for (var i : ages) {
            System.out.println(i);
        }
        System.out.println(Arrays.toString(ages));
    }
}
