package scan;

import java.util.Scanner;

public class ScannerKeyBoardTest {
    public static void main(String[] args) {
        //System.in标准输入
        var sc = new Scanner(System.in);
        //指定换行符为拆分符号，这样在录入文字的时候可以录入空格，tab 空白。不然会被拆多行的。
        //当然整行读取还有 hasNextLine() nextLine()两个方法可用。
        sc.useDelimiter("\n");
        //字符串数据
        while(sc.hasNext()){
            System.out.println("键入内容："+sc.next());
        }
    }
}
