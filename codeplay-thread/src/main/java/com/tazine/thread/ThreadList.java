package com.tazine.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 查看 JVM 中的线程名
 *
 * @author frank
 * @date 2018/02/26
 */
public class ThreadList {

    public static void main(String[] args) {

        for (String s : getThreadGroups(getRootThreadGroups())) {
            System.out.println(s);
        }
    }

    /**
     * 获得根线程组
     *
     * @return
     */
    public static ThreadGroup getRootThreadGroups() {
        ThreadGroup rootThreadGroup = Thread.currentThread().getThreadGroup(); // 获得当前线程组
        while (true) {
            if (null != rootThreadGroup.getParent()) {
                rootThreadGroup = rootThreadGroup.getParent();
            } else {
                break;
            }
        }
        return rootThreadGroup;
    }

    /**
     * 获得给定线程组中所有线程名
     *
     * @param group
     * @return
     */
    public static List<String> getThreads(ThreadGroup group) {
        List<String> threadList = new ArrayList<String>();
        Thread[] threads = new Thread[group.activeCount()];
        int count = group.enumerate(threads, false);
        for (int i = 0; i < count; i++) {
            threadList.add(group.getName() + " 线程组：" + threads[i].getName());
        }
        return threadList;
    }

    /**
     * 获得线程组中子线程组
     *
     * @param group
     * @return
     */
    public static List<String> getThreadGroups(ThreadGroup group) {
        List<String> threadList = getThreads(group);
        ThreadGroup[] groups = new ThreadGroup[group.activeGroupCount()];
        int count = group.enumerate(groups, false);
        for (int i = 0; i < count; i++) {
            threadList.addAll(getThreads(groups[i]));
        }
        return threadList;
    }
}
