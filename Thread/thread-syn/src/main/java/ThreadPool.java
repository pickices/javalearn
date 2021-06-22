import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadPool {
    public static void main(String[] args) {
        ThreadFactory threadFactory;
        ExecutorService executorServicr = Executors.newFixedThreadPool(10);
        executorServicr.execute(new MyThread());
        executorServicr.execute(new MyThread());
        executorServicr.execute(new MyThread());
        executorServicr.execute(new MyThread());
        executorServicr.shutdown();

    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}