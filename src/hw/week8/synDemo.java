package hw.week8;

public class synDemo {
    public static int count;
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                for (int i = 0; i < 10; i++) count++;
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                for (int i = 0; i < 10; i++) count++;
            }
        });

        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);


    }
}
