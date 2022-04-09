package arraysL;

import java.util.Arrays;

/**
 * 
 */
public class Num2RMB {
    // private String[] hanArr = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};

    // private String[] unitArr = {"十","百","千"};

    private String[] divide(double num){
        var zheng = (long)num;
        var xiao = Math.round((num-zheng)*100);
        return new String[] {zheng+"",String.valueOf(xiao)};
    }

    public static void main(String[] args) {
        var nr = new Num2RMB();
        System.out.println(Arrays.toString(nr.divide(1234.457)));
    }
}
