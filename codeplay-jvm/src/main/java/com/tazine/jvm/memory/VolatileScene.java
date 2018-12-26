package com.tazine.jvm.memory;

/**
 * Volatile 使用场景
 *
 * @author frank
 * @date 2017/12/12
 */
public class VolatileScene {

    private volatile boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void run() {
        while (flag) {
        }
        System.out.println(Thread.currentThread().getName() + " 停止执行");
    }

    public static void main(String[] args) {

        VolatileScene scene = new VolatileScene();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                scene.setFlag(false);
            }
        }).start();

        scene.run();
    }
}
