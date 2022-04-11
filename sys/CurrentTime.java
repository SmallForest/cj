package sys;

public class CurrentTime {
    public static void main(String[] args) {
        //获取当前时间 毫秒级别 常用 除以1000得到秒
        long l = System.currentTimeMillis();
        System.out.println("毫秒ms："+l);
        //获取当前时间 纳秒 除以1000000得到秒，不要使用好多系统不支持获取纳秒级别的时间
        var l2 = System.nanoTime();
        System.out.println("纳秒ns："+l2);
    }
}
