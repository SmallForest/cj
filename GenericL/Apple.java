package GenericL;

public class Apple<T> {
    //使用T类型定义实例变量
    private T info;
    //构造器
    public Apple(){};
    //下面方法中使用T类型来定义构造器
    public Apple(T info){
        this.info = info;
    }
    public void setInfo(T info){
        this.info = info;
    }
    public T getInfo() {
        return info;
    }

    public static void main(String[] args) {
        //类型实参 选用 String
        Apple<String> a1 = new Apple<>("橘子味道的苹果");
        System.out.println(a1.getInfo());

        //类型实参 选用 Double
        Apple<Double> a2 = new Apple<>(2.);
        System.out.println(a2.getInfo());

    }
}
