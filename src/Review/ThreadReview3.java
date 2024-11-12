package Review;

public class ThreadReview3 {
    public static void main(String[] args) throws InterruptedException {
        SellTicket1 sellTicket1 = new SellTicket1();
        System.out.println("当前的状态" + sellTicket1.getState());
//        SellTicket1 sellTicket2 = new SellTicket1();
//        SellTicket1 sellTicket3 = new SellTicket1();
        sellTicket1.start();
//        sellTicket2.start();
//        sellTicket3.start();
        while (sellTicket1.getState() != Thread.State.TERMINATED){
            for (int i = 0; i < 11; i++) {
                System.out.println("当前状态" + sellTicket1.getState());
                Thread.sleep(1000);
            }
        }
        System.out.println("最后的状态为" + sellTicket1.getState());
    }
}

class SellTicket1 extends Thread{
    private static int ticketNum = 50;

    @Override
    public void run() {
        while(true){
            if(ticketNum < 0){
                System.out.println("售票结束...");
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口" + Thread.currentThread().getName() + " 售出一张票" +
                    "剩余票数 = " + (--ticketNum));
        }
        System.out.println("当前的状态" + Thread.currentThread().getState());
    }
}