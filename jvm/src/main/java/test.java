import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test{

    public void test() {
        synchronized (this.getClass()) {
            for (int i = 0; i < 10000; i++) {
                System.out.println("test" +Thread.currentThread().getName()+" is " +i);
            }
        }
    }

    public static void main(String[] args) {
        test t1 = new test();
        test t2 = new test();
        //用线程池
        ExecutorService exService = Executors.newCachedThreadPool();
        //开启一个线程执行方法
        exService.execute(() -> {
            t1.test();
        });
        exService.execute(() -> {
            t2.test();
        });
    }
}
