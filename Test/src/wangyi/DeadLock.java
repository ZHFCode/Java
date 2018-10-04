package wangyi;

/**
 * Created by ZHF on 2018/9/8.
 */
public class DeadLock {
    public static Object obj1 = new Object();
    public static Object obj2 = new Object();

    public static void main(String[] args) {
        DeadThread1 deadThread1 = new DeadThread1();
        DeadThread2 deadThread2 = new DeadThread2();
        Thread thread1 = new Thread(deadThread1);
        Thread thread2 = new Thread(deadThread2);

        thread1.start();
        thread2.start();
    }
}

class DeadThread1 implements Runnable {
    @Override
    public void run() {
        synchronized (DeadLock.obj1) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {}
            synchronized (DeadLock.obj2) {
                System.out.println("dead lock1");
            }
        }
    }
}

class DeadThread2 implements Runnable {
    @Override
    public void run() {
        synchronized (DeadLock.obj2) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {}
            synchronized (DeadLock.obj1) {
                System.out.println("dead lock2");
            }
        }
    }
}
