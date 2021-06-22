public class ThreadTicket implements Runnable{

    private int ticket = 10;

    public void run(){
        while (true){
            System.out.println(Thread.currentThread().getName()+"抢到了第"+ticket--+"张票");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(ticket<=0) break;
        }
    }

    public static void main(String[] args) {
        ThreadTicket thread1 = new ThreadTicket();
        ThreadTicket thread2 = new ThreadTicket();
        ThreadTicket thread3 = new ThreadTicket();
        new Thread(thread1,"小明").start();
        new Thread(thread2,"老师").start();
        new Thread(thread3,"黄牛").start();
    }
}
