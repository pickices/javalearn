import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Foobar {

    HashMap map = new HashMap();


    public static void main(String[] args) {
        B b = new B(100);
        new Thread(()->{
            try {
                b.foo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                b.bar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class B {
    private int n;
    int flag =1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();


    public B(int n) {
        this.n = n;
    }

    public void foo() throws InterruptedException {


        lock.lock();
        for (int i = 0; i < n; i++) {
            while(flag!=1){
                condition1.await();
            }
            System.out.println("foo");
            flag = 2;
            condition2.signal();
        }
        lock.unlock();
    }

    public void bar() throws InterruptedException {

        lock.lock();
        for (int i = 0; i < n; i++) {
            while(flag!=2){
                condition2.await();
            }
            System.out.println("bar");
            flag=1;
            condition1.signal();
        }
        lock.unlock();
    }
}
