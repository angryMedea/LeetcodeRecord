package Review;

public class ThreadReview2 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Human human = new Human();
        Thread thread = new Thread(dog);
        thread.start();
        Thread thread1 = new Thread(human);
        thread1.start();
    }
}

class Dog implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i < 11 ; i++) {
            System.out.println("hello world" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Human implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            System.out.println("hi" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}