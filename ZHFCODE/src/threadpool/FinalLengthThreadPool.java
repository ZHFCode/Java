package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ZHF on 2018/9/10.
 */
public class FinalLengthThreadPool {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 100; i++) {
            es.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        es.shutdown();
        
    }
}
