package com.tazine.thread.daemon;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 守护线程与用户线程，当用户线程退出后，守护线程也会随着退出.
 *
 * @author Frank
 * @since 1.0.0
 */
public class MainThread {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DaemonThread thread = new DaemonThread("DaemonThread");
        thread.setDaemon(true);
        thread.start();

        if (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}

/**
 * 守护线程：不断向外做 IO 输出
 */
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
            while (i < 100) {
                System.out.println("打印内容：" + name.concat(":").concat(String.valueOf(i)));
                outputStream.write("\r\n".concat(name).concat(":").concat(String.valueOf(i)).getBytes());
                i++;
                sleep(1000);
            }
            System.out.println("线程结束执行");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
