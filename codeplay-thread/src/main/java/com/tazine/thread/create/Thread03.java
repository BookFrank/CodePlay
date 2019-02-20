package com.tazine.thread.create;

import java.util.concurrent.Callable;

/**
 * 通过Callable创建
 * @author frank
 * @date 2017/02/20
 */
public class Thread03 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.err.println("通过实现Callable接口创建的线程正在执行");
        Thread.sleep(3000);
        return "Hello Thread03";
    }
}
