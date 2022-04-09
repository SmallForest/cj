package boxingUnboxing;

public class AutoBoxingUnboxing {
    public static void main(String[] args) {
        //常规int转Integer类型 自动装箱
        Integer a = 5;
        //常规布尔赋值Object 自动装箱
        Object boolObj = true;
        //自动拆箱
        int b = a;
        System.out.println(b);
        if(boolObj instanceof Boolean){
            //自动拆箱
            boolean bl = (Boolean)boolObj;
            System.out.println(bl);
        }

        var s = "1.23";
        var ds =Double.parseDouble(s);
        System.out.println(ds);

        var dsObj = Double.valueOf(s);
        System.out.println(dsObj.toString());

        System.out.println(dsObj==ds);

        var i = 1000;
        System.out.println(String.valueOf(i));
        Integer it = 5;
        
        System.out.println(it.toString());
        System.out.println(it+"");
        System.out.println(i+"");


    }
}
