package com.tazine.thread.concurrent;

import java.util.concurrent.*;

/**
 * Callable and Future Demo 3
 *
 * @author frank
 * @since 1.0.0
 */
public class CallableAndFuture3 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newCachedThreadPool();
        CompletionService<Integer> service = new ExecutorCompletionService<Integer>(pool);

        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            service.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return taskId;
                }
            });
        }

        /*
         * 可以做一些额外的事情，不着急拿到结果的话
         */

        for (int i = 0; i < 5; i++) {
            System.out.println(service.take().get());
        }

        // 结果 0 1 2 4 3
        /*
           提交到CompletionService中的Future是按照完成的顺序排列的，
           List<Future> 是按照添加的顺序排列的
         */
    }
}
