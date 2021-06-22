public class DeadLock {
    public static void main(String[] args) {
        Makeup makeup = new Makeup(0);
        Makeup makeup1 = new Makeup(1);
        new Thread(makeup,"小明").start();
        new  Thread(makeup1,"小红").start();
    }
}

class Dior{

}

class Mirror{

}

class Makeup implements Runnable{
    static Dior dior = new Dior();
    static Mirror mirror = new Mirror();
    private int choice;

    public Makeup(int choice) {
        this.choice = choice;
    }

    @Override
    public void run() {
        makeup();
    }

    public void makeup(){
        if(choice==0){
            synchronized (dior){
                System.out.println(Thread.currentThread().getName()+"正在涂口红");
            }
            synchronized (mirror){
                System.out.println(Thread.currentThread().getName()+"正在照镜子");
            }
        }
        else{
            synchronized (mirror){
                System.out.println(Thread.currentThread().getName()+"正在照镜子");
            }
            synchronized (dior){
                System.out.println(Thread.currentThread().getName()+"正在涂口红");
            }
        }

    }
}