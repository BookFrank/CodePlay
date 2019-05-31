package com.tazine.third.zookeeper;

import java.util.List;

/**
 * ZkTest
 *
 * @author frank
 * @date 2019/05/28
 */
public class ZkTest {

    public static void main(String[] args) throws Exception {

        BaseZookeeper zk = new BaseZookeeper();
        zk.connectZk("127.0.0.1:2181");

        List<String> children = zk.getChildren("/");
        System.out.println(children);

        Thread.sleep(1000);

        zk.getDataAsync("/jiaer");

        Thread.sleep(2000);
    }
}
