package scan;

import java.io.File;
import java.util.Scanner;

public class ScannerFileTest {
    public static void main(String[] args) throws Exception {
        var sc = new Scanner(new File("scan/ScannerFileTest.java"));
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
    }
}
