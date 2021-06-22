import static java.lang.Thread.*;

public class ThreadState {

    public static void main(String[] args) {

        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("//////////");
        });

        State state = thread.getState();
        System.out.println(state);

        thread.start();
        state = thread.getState();
        System.out.println(state);


        while(state!= State.TERMINATED){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = thread.getState();
            System.out.println(state);
        }

    }
}
