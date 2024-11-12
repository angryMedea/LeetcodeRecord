package Review;

public class ThreadReview1{
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();
        cat.start();
        System.out.println("主线程是啥？ " + Thread.currentThread().getName());
        for (int i = 1; i <= 20; i++) {
            System.out.println("主线程 i = " + i);
            Thread.sleep(1000);
        }

    }
}

class Cat extends Thread{
   int times = 0;

    @Override
    public void run() {
        while (true){
        System.out.println("喵喵" + (++times) +" 线程名" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(times == 10){
                break;
            }
        }
    }

}