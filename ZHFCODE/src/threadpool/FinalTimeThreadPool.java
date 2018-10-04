package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by ZHF on 2018/9/10.
 */
public class FinalTimeThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 100; i++) {
            ses.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            }, 3, TimeUnit.SECONDS);
        }
        ses.shutdown();
    }
}
