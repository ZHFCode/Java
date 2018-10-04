package threadpool;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by ZHF on 2018/9/10.
 */
public class CallableTest implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        return new Random().nextInt();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTest callableTest = new CallableTest();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callableTest);
        Thread thread = new Thread(futureTask);
        thread.start();

        Integer i = futureTask.get();
        System.out.println(i);
    }
}
