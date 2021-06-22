public class UnSafeBank {
    public static void main(String[] args) {
        Account account = new Account(100,"结婚基金");
        Drawing drawing = new Drawing(account,100,0);
        Drawing drawing2 = new Drawing(account,50,0);
        new Thread(drawing,"小明").start();
        new Thread(drawing2,"小红").start();
    }
}

class Account{
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Drawing implements Runnable{

    Account account;
    int drawingmoney;
    int handmoney;

    public Drawing(Account account, int drawingmoney, int handmoney) {
        this.account = account;
        this.drawingmoney = drawingmoney;
        this.handmoney = handmoney;
    }

    @Override
    public void run() {
        synchronized (account){
            if(account.money-drawingmoney<0){
                System.out.println(Thread.currentThread().getName()+":余额不足");
            }
            else{
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.money -=drawingmoney;
                handmoney += drawingmoney;
                System.out.println(Thread.currentThread().getName()+":取走:"+drawingmoney+"，账户余额："+account.money+"，现金有："+handmoney);
            }
        }
    }
}
