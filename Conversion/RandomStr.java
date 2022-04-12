package Conversion;

public class RandomStr {
    public static void main(String[] args) {
        var result ="";
        for(var i=0;i<6;i++){
            var n = (int)(Math.random()*26+97);
            result+=(char)n;
        }
        System.out.println(result);

        //这是错误的，5.6默认是double类型的，无法自动转float。需要 float f = (float)5.6;
        //float f = 5.6;

        var s = "5.6";
        float s1 = Float.parseFloat(s);
        System.out.println(s1);
    }
}
