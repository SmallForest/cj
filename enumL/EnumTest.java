package enumL;

public class EnumTest {
    public void judge(SeasonEnum s){
        switch(s)
        {
            case SPRING:
                System.out.println("春天");
                break;
            case SUMMER:
                System.out.println("夏天");
                break;
            case FALL:
                System.out.println("秋天");
                break;
            case WINTER:
                System.out.println("冬天");
                break;
        }
    }
    public static void main(String[] args) {
        for (var s : SeasonEnum.values()) {
            System.out.println(s);
        }
        
        //使用枚举实例，是枚举类名.枚举实例名 SeasonEnum.SPRING
        new EnumTest().judge(SeasonEnum.SPRING);
    }
}
