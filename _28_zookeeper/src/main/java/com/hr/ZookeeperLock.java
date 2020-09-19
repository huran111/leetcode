package com.hr;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-16 22:27
 */
public class ZookeeperLock {
    String IP = "39.106.69.95:2181";
    CountDownLatch countDownLatch = new CountDownLatch(1);
    static ZooKeeper zooKeeper;
    private static final String LOCK_ROOT_PATH = "/Locks";
    private static final String LOCK_NODE_NAME = "Lock_";
    private static String locakPath;

    public void acquireLock() throws KeeperException, InterruptedException {
        createLock();
        attemptLock();
    }

    public ZookeeperLock() {
        try {
            zooKeeper = new ZooKeeper(IP, 5000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (event.getType() == Event.EventType.None) {
                        if (event.getState() == Event.KeeperState.SyncConnected) {
                            System.out.println("连接成功");
                            countDownLatch.countDown();
                        }
                    }
                }
            });
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createLock() throws KeeperException, InterruptedException {
        final Stat exists = zooKeeper.exists(LOCK_ROOT_PATH, false);
        if (exists == null) {
            zooKeeper.create(LOCK_ROOT_PATH, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        locakPath = zooKeeper.create(LOCK_ROOT_PATH + "/" + LOCK_NODE_NAME, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("节点创建成功:" + locakPath);
    }

    Watcher watcher = new Watcher() {
        @Override
        public void process(WatchedEvent event) {
            if (event.getType() == Event.EventType.NodeDeleted) {
                synchronized (watcher) {
                    watcher.notifyAll();
                }
            }
        }
    };

    //尝试获取锁
    private void attemptLock() throws KeeperException, InterruptedException {
        final List<String> list = zooKeeper.getChildren(LOCK_ROOT_PATH, false);
        Collections.sort(list);
        int index = list.indexOf(locakPath.substring(LOCK_ROOT_PATH.length() + 1));
        if (index == 0) {
            System.out.println("获取锁成功");
        }else {
            //上一个节点的路径
            final String s = list.get(index - 1);
            final Stat stat = zooKeeper.exists(LOCK_ROOT_PATH + "/" + s, watcher);
            if (stat == null) {
                attemptLock();
            } else {
                synchronized (this) {
                    watcher.wait();
                }
            }
        }

    }
    public void releaseLock() throws InterruptedException, KeeperException {
        zooKeeper.delete(locakPath,-1);
        zooKeeper.close();
        System.out.println("锁已经释放");
    }
    public static void main(String[] args) {
        try {
            ZookeeperLock lock = new ZookeeperLock();
            lock.createLock();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}