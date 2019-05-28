package com.tazine.third.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * BaseZookeeper
 *
 * @author frank
 * @date 2019/05/28
 */
public class BaseZookeeper implements Watcher {

    private static final int SESSION_TIMEOUT = 2000;

    private ZooKeeper zooKeeper;

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    /**
     * Zk API 与服务器建立连接是异步的，调用会立马从Zk构造函数返回，当与服务器建立好连接之后会调用Watcher中的process方法进行处理，
     * process方法会接受一个WatchedEvent类型的参数，用于表明发生了什么事件
     *
     * @param watchedEvent WatchedEvent
     */
    @Override
    public void process(WatchedEvent watchedEvent) {
        /*
         * WatchedEvent 包含两方面重要信息：
         * 1. 与 zk 服务器连接的状态信息
         * 可以调用 watchedEvent.getState() 方法获取与zk服务器连接的状态信息，SyncConnected、Disconnected、ConnectedReadOnly和AuthFailed
         * 2. 发生的具体事件类型信息
         * watchedEvent.getState()方法只是获取与zk服务器连接的状态信息，但在同一个连接状态下，还会发生很多事件的类型。例如在zk中，我们可以watch
         * 一个节点的数据内容，当这个节点的数据被改变时，我们可以获取到这个事件。类似的还有子节点列表变化事件等等。
         * 这就需要我们在SyncConnected同一种连接状态下区分多个事件类型。可以通过watchedEvent.getType()
         * 方法获取具体的事件类型。事件类型的取值包括None、NodeCreated、NodeDeleted、NodeDataChanged和NodeChildrenChanged。
         */
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            System.out.println("Watch received event " + watchedEvent.getState().name());
            countDownLatch.countDown();
        }
    }

    /**
     * 连接 zk
     *
     * @param host
     * @throws Exception
     */
    public void connectZk(String host) throws Exception {
        // new ZooKeeper 服务器地址、和服务端连接session超时事件、Watcher对象
        zooKeeper = new ZooKeeper(host, SESSION_TIMEOUT, this);
        countDownLatch.await();
        System.out.println("Zookeeper connect success");
    }

    /**
     * 关闭连接
     *
     * @throws InterruptedException
     */
    public void closeConnection() throws InterruptedException {
        if (null != zooKeeper) {
            zooKeeper.close();
        }
    }

    /**
     * 创建节点    
     *
     * @param path    
     * @param data    
     * @throws Exception    
     */
    public String createNode(String path, String data) throws Exception {
        return this.zooKeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    public List<String> getChildren(String path) throws KeeperException, InterruptedException {
        List<String> children = zooKeeper.getChildren(path, false);
        return children;
    }

    /**
     * 获取 path 下 child 的数量
     *
     * @param path
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public Integer getChildrenNum(String path) throws KeeperException, InterruptedException {
        return getChildren(path).size();
    }

    /**
     * 获取节点上面的数据
     *
     * @param path
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public String getData(String path) throws KeeperException, InterruptedException {
        byte[] data = zooKeeper.getData(path, false, null);
        if (null == data) {
            return "";
        } else {
            return new String(data);
        }
    }

    /**
     * 设置节点数据
     *
     * @param path
     * @param data
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public Stat setData(String path, String data) throws KeeperException, InterruptedException {
        Stat stat = zooKeeper.setData(path, data.getBytes(), -1);
        return stat;
    }

    public void deleteNode(String path) throws KeeperException, InterruptedException {
        zooKeeper.delete(path, -1);
    }

    /**
     * 获取创建时间
     *
     * @param path
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public String getCTime(String path) throws KeeperException, InterruptedException {
        Stat stat = zooKeeper.exists(path, false);
        return String.valueOf(stat.getCtime());
    }
}
