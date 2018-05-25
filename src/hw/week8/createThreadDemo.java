package hw.week8;


class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello world.");
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("Hello world.");
    }
}

public class createThreadDemo {

    public static void main(String[] args) {
        // Way 1: implements Runnable
        Thread t1 = new Thread(new MyThread());
        t1.start();

        // Way 2: extends Thread
        Thread t2 = new MyThread2();
        t2.start();

        // Way 3: anonymous inner class
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world.");
            }
        });
        t3.start();

        // Way 4: lambda expression
        Thread t4 = new Thread(() -> System.out.println("Hello world."));
        t4.start();
    }
}
