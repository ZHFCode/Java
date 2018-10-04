package threadpool;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by ZHF on 2018/9/10.
 */
public class CallableThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(5);
        LinkedList<Future> list = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            Future<String> f = es.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(2000);
                    return Thread.currentThread().getName();
                }
            });
            list.add(f);
        }
        for (Future f:list
             ) {
            String s = (String)f.get();
            System.out.println(s);
        }
        es.shutdown();
    }
}
