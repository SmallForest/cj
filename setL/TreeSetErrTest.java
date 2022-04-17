package setL;

import java.util.Date;
import java.util.TreeSet;

class Err{}
public class TreeSetErrTest {
    public static void main(String[] args) {
        var ts = new TreeSet();
        //ts.add(new Err());

        ts.add(new String("abc"));
        ts.add(new Date());
    }
}
