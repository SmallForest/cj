package AnnotationL;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ErrorUtils {
    //@SafeVarargs
    public static void faultyMethod(List<String>... listStrArray){
        //java不允许创建泛型数组，因此listArray只能被当成List[]处理
        //此时相当于把List<String>赋给了List，已经发生了堆污染
        List[] listArray = listStrArray;
        List<Integer> myList = new ArrayList<>();
        myList.add(new Random().nextInt(100));
        //把listArray的第一个元素赋为myArray
        listArray[0] = myList;
        String s = listStrArray[0].get(0);
    }
}
