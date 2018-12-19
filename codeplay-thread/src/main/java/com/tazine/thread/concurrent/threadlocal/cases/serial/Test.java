package com.tazine.thread.concurrent.threadlocal.cases.serial;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lina on 2018/1/8.
 *
 * @author frank
 * @date 2018/1/8
 */
public class Test {

    public static void main(String[] args) {

        SequenceGenerator generator = new SequenceA();
        SequenceGenerator generator1 = new SequenceB();
        SequenceGenerator generator2 = new SequenceC();

        GeneratorThread run = new GeneratorThread(generator2);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i=0;i<3;i++){
            executor.execute(run);
        }

        executor.shutdown();


    }


}
