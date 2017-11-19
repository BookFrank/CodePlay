package com.tazine.daemon;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class DaemonThread extends Thread {

    private String name;

    public DaemonThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        File file = new File("/Users/lina/dsp/daemon.txt");
        FileOutputStream outputStream = null;
        int i = 0;
        System.out.println("线程开始执行");
        try {
            outputStream = new FileOutputStream(file);
            while (i < 100){
                System.out.println("打印内容：" + name.concat(":").concat(String.valueOf(i)));
                outputStream.write("\r\n".concat(name).concat(":").concat(String.valueOf(i)).getBytes());
                i++;
                sleep(1000);
            }
            System.out.println("线程结束执行");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != outputStream){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


/**
 * Created on 2017/11/18.
 * @author Frank
 */
public class MainThread {

    public static void main(String[] args) {

        ExecutorService executors = new ThreadPoolExecutor();

        Scanner scanner = new Scanner(System.in);

        DaemonThread thread = new DaemonThread("DaemonThread");
        thread.setDaemon(true);
        thread.start();

        if (scanner.hasNext()) {
            System.out.println(scanner.next());
        }

    }


}
