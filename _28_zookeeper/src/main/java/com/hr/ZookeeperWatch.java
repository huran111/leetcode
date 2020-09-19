package com.hr;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * @program: leetcode
 * @description: 监听机制
 * @author: HuRan
 * @create: 2020-09-15 21:13
 */
public class ZookeeperWatch implements Watcher {
    static ZooKeeper zooKeeper;
    static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        zooKeeper = new ZooKeeper("39.106.69.95:2181", 500, new ZookeeperWatch());
        countDownLatch.await();
        System.out.println(zooKeeper.getSessionId());
        zooKeeper.addAuthInfo("digest", "huran:123456".getBytes());
        final byte[] data = zooKeeper.getData("/node1", false, null);
        System.out.println(new java.lang.String(data));
        zooKeeper.close();
    }

    @Before
    public void before() throws IOException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        zooKeeper = new ZooKeeper("39.106.69.95:2181", 500, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                if (event.getState() == Event.KeeperState.SyncConnected) {
                    countDownLatch.countDown();
                }
                System.out.println(event.getPath());//路径
                System.out.println(event.getType());//类型
            }
        });
        countDownLatch.await();
    }

    @Test
    public void watcherExists() throws KeeperException, InterruptedException {
        zooKeeper.exists("/watcher1", true);
        Thread.sleep(50000);
    }


    @Test
    public void watcherExists2() throws KeeperException, InterruptedException {
        zooKeeper.exists("/watcher1", new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println(event.getType());
                System.out.println(event.getPath());
            }
        });
        Thread.sleep(50000);
    }

    @Test
    public void watcherExists3() throws KeeperException, InterruptedException {
        //一次性watcher
        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println(event.getType());
                System.out.println(event.getPath());
                try {
                    zooKeeper.exists("/watcher1", this);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        zooKeeper.exists("/watcher1", watcher);
        Thread.sleep(50000);
    }

    @Test
    public void watcherExists4() throws KeeperException, InterruptedException {

        //多个监听器对象
        zooKeeper.exists("/watcher1", new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println(event.getType());
                System.out.println(event.getPath());
            }
        });
        zooKeeper.exists("/watcher1", new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println(event.getType());
                System.out.println(event.getPath());
            }
        });
        Thread.sleep(50000);
    }

    @After
    public void after() throws InterruptedException {
        zooKeeper.close();
    }


    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            System.out.println("连接创建成功");
            countDownLatch.countDown();
        } else if (watchedEvent.getState() == Event.KeeperState.Disconnected) {
            System.out.println("断开连接");
        } else if (watchedEvent.getState() == Event.KeeperState.Expired) {
            System.out.println("会话超时");
            try {
                zooKeeper = new ZooKeeper("39.106.69.95:2181", 500, new ZookeeperWatch());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (watchedEvent.getState() == Event.KeeperState.AuthFailed) {
            System.out.println("认证失败");

        }
    }


}