import java.util.concurrent.*;

public class CyclicBarrierTest {

    public static void main(String[] args) throws InterruptedException {

        Runnable barrierAction;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, new Runnable() {
            @Override
            public void run() {
                System.out.println("召唤神龙成功！");
            }
        });
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        boolean offer = blockingQueue.offer("a",3, TimeUnit.SECONDS);
        for (int i = 1; i <= 7; i++) {
            final int temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集到了第"+temp+"个龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
    
}
