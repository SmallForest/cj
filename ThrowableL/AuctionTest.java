package ThrowableL;

public class AuctionTest {
    private double initPrice = 30.0;
    public void bid(String bidPrice) throws AuctionException
    {
        var d = .0;
        try {
            d = Double.parseDouble(bidPrice);
        }catch (Exception e){
            //输出栈信息
            e.printStackTrace();
            throw new AuctionException("竞拍需要是数字");
        }
        if (initPrice>d){
            throw new AuctionException("竞拍价要比起拍价高才行");
        }
        initPrice = d;
    }

    public static void main(String[] args) {
        var at = new AuctionTest();
        try {
            at.bid("dd");
        }catch (AuctionException ae){
            //捕获到抛出的异常
            System.out.println(ae.getMessage());
        }
    }
}
