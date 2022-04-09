package Conversion;

public class RandomStr {
    public static void main(String[] args) {
        var result ="";
        for(var i=0;i<6;i++){
            var n = (int)(Math.random()*26+97);
            result+=(char)n;
        }
        System.out.println(result);

        var s = "5.6";
        float s1 = Float.parseFloat(s);
        System.out.println(s1);
    }
}
