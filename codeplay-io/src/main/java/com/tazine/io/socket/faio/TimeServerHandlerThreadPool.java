package com.tazine.io.socket.faio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * TimeServerHandlerThreadPool
 *
 * @date 2017/11/18
 */
public class TimeServerHandlerThreadPool {

    private ExecutorService executor;

    public TimeServerHandlerThreadPool(int maxPoolSize, int queueSize) {
        executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), maxPoolSize, 120L,
            TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize));

    }

    public void execute(Runnable task) {
        executor.execute(task);
    }
}
