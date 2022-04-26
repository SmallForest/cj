package ThrowableL;

//自定义异常类
public class AuctionException extends Exception {
    //无参构造器
    public AuctionException() {
    }

    //字符串参数构造器
    public AuctionException(String s) {
        super(s);
    }
}
