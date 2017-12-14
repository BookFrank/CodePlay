package com.tazine.thread.daemon;

import java.util.Scanner;

/**
 * 守护线程与用户线程，当用户线程退出后，守护线程也会随着退出.
 *
 * @author Frank
 * @since 1.0.0
 */
public class DaemonThreadDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DaemonThread thread = new DaemonThread("DaemonThread");
        thread.setDaemon(true);
        thread.start();

        if (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        // scanner.hasNext()会使main线程阻塞在等待输入，输入后执行完毕守护线程也会终止。
    }
}

/**
 * 守护线程：不断向外做 IO 输出
 */
class DaemonThread extends Thread {

    private String name;

    DaemonThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int i = 0;
        System.out.println("线程开始执行");
        try {
            while (i < 100) {
                System.out.println("打印内容：" + name.concat(":").concat(String.valueOf(i)));
                i++;
                sleep(1000L);
            }
            System.out.println("线程结束执行");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
