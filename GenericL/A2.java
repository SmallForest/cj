package GenericL;

public class A2 extends Apple{
    //重写父类中的getInfo
    public String getInfo(){
        //父类返回的是Object类型的
        //super.getInfo();
        //调用toString()转String
        return super.getInfo().toString();
    }

    public static void main(String[] args) {
        var a2 = new A2();
        a2.setInfo("香梨");
        System.out.println(a2.getInfo());
    }
}
