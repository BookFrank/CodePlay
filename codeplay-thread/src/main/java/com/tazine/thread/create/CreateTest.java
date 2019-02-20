package com.tazine.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * CreateTest
 *
 * @author frank
 * @date 2017/02/20
 */
public class CreateTest {

    public static void main(String[] args) throws Exception {

        Callable<String> callable = new Thread03();
        // Callable + FutureTask
        FutureTask<String> futureTask = new FutureTask<>(callable);

        new Thread(futureTask).start();

        //System.err.println(futureTask.get());

    }

}
