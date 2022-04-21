package CollectionsL;

import java.util.ArrayList;
import java.util.Collections;

public class SortTest {
    public static void main(String[] args) {
        var nums = new ArrayList();
        nums.add(2);
        nums.add(-5);
        nums.add(3);
        nums.add(0);
        System.out.println(nums);
        //反转
        Collections.reverse(nums);
        System.out.println(nums);
        //排序
        Collections.sort(nums);
        System.out.println(nums);
        //洗牌
        Collections.shuffle(nums);
        System.out.println(nums);
    }
}
