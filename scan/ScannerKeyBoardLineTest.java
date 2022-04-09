package scan;

import java.util.Scanner;

public class ScannerKeyBoardLineTest {
    public static void main(String[] args) {
        var sc =new Scanner(System.in);
        while(sc.hasNextLine()){
            System.out.println("键入整行数据"+sc.nextLine());
        }
    }
}
