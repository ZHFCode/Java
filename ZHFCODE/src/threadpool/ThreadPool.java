package threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ZHF on 2018/9/10.
 */
public class ThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor pool
                = new ThreadPoolExecutor(1, 2, 3, TimeUnit.SECONDS, new LinkedBlockingQueue<>(3));
        pool.execute(new ThreadTest());
        pool.execute(new ThreadTest());
        pool.execute(new ThreadTest());
        pool.execute(new ThreadTest());

        pool.execute(new ThreadTest());
//        pool.execute(new ThreadTest());
        pool.shutdown();
    }
}

class ThreadTest implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}