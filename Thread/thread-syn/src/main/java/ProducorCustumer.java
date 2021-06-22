public class ProducorCustumer {

    public static void main(String[] args) {
        SynContainner synContainner = new SynContainner();
        Productor productor = new Productor(synContainner);
        Custumer custumer = new Custumer(synContainner);
        new Thread(productor).start();
        new Thread(custumer).start();
    }
}

class Chicken{

}

class Productor implements Runnable{

    SynContainner synContainner;

    public Productor(SynContainner synContainner) {
        this.synContainner = synContainner;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synContainner.push(new Chicken());
            System.out.println("生产了第"+i+"只鸡");
        }
    }
}

class Custumer implements Runnable{
    SynContainner synContainner;

    public Custumer(SynContainner synContainner) {
        this.synContainner = synContainner;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synContainner.pop();
            System.out.println("消费了第"+i+"只鸡");
        }
    }
}

class SynContainner{
    Chicken[] chickens = new Chicken[10];
    int count=0;

    public synchronized void push(Chicken chicken){
        if(count==10) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            chickens[count] = chicken;
            count++;
            this.notify();
    }

    public synchronized Chicken pop(){
        if(count==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Chicken chicken = chickens[count];
        this.notify();
        return chicken;
    }
}