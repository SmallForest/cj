package GenericL;

public class A1 extends Apple<String>{
    //重写父类
    public String getInfo(){
        return "子类A1 "+super.getInfo();
    }

    //下面重写是错误的，返回值和父类不同。因为我们这里继承了Apple<String>
//    public Object getInfo(){
//        return "子类A1 ";
//    }


    public static void main(String[] args) {
        var a1 = new A1();
        a1.setInfo("猪头肉");
        System.out.println(a1.getInfo());
    }
}
