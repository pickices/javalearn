public class ThreadRace implements Runnable{
    private static String winner;
    private boolean gamecontinue = true;

    public void run(){

        for (int i = 1; i < 101; i++) {
            if(gamecontinue==false) break;
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"步");
        }
        if(gamecontinue==true){
            gamecontinue=false;
            System.out.println("winner is "+Thread.currentThread().getName());
        }

    }

    public static void main(String[] args) {
        ThreadRace thread = new ThreadRace();
        new Thread(thread,"兔子").start();
        new Thread(thread,"乌龟").start();
    }
}
