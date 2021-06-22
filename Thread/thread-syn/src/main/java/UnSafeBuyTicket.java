import java.util.concurrent.locks.ReentrantLock;

public class UnSafeBuyTicket {

    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket,"小明").start();
        new Thread(buyTicket,"老师").start();
        new Thread(buyTicket,"黄牛").start();
    }
}

class BuyTicket implements Runnable{

    private boolean flag=true;
    private int ticketnum=100;
    private final ReentrantLock lock = new ReentrantLock();

    public void buy(){
        while(flag){
            lock.lock();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(ticketnum>0){
                System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketnum--+"张票");
            }
            else{
                flag=false;
            }
            lock.unlock();
        }
    }

    @Override
    public void run() {
        while (flag){
            buy();
        }
    }
}
