package com.tazine.thread.concurrent.ret;

import java.util.concurrent.*;

/**
 * Callable & Future
 *
 * @author frank
 * @since 1.0.0
 */
public class CallableAndFuture {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newSingleThreadExecutor();

        Future<Integer> future = pool.submit(new GetOne());

        try {
            System.out.println(future.get());
            System.out.println("Hello");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //pool.shutdownNow();
        pool.shutdown();

    }

}

class GetOne implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        return 10;
    }
}
