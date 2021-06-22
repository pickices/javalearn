public class ThreadJoin implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("vip线程"+i);
        }
    }

    public static void main(String[] args) {
        ThreadJoin threadJoin = new ThreadJoin();
        Thread thread = new Thread(threadJoin);
        thread.start();

        for (int i = 0; i < 500; i++) {
            if(i==200){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("main线程"+i);
        }
    }
}
