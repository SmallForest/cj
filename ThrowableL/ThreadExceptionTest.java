package ThrowableL;

public class ThreadExceptionTest implements Runnable {
    @Override
    public void run() {
        firstMethod();
    }

    public void firstMethod() {
        secondMethod();
    }

    public void secondMethod() {
        var a = 5;
        var b = 0;
        var c = a / b;
    }

    public static void main(String[] args) {
        //启动并发程序
        new Thread(new ThreadExceptionTest()).start();
    }
}
