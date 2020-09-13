package com.hr;

import org.apache.zookeeper.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-13 14:34
 */
public class ZookeeperCreate {
    ZooKeeper zooKeeper;

    @Before
    public void before() throws IOException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        zooKeeper = new ZooKeeper("39.106.69.95:2181", 500, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    System.out.println("连接创建成功");
                    countDownLatch.countDown();
                }
            }
        });
        countDownLatch.await();
        System.out.println(zooKeeper.getSessionId());

    }

    @After
    public void after() throws InterruptedException {
        zooKeeper.close();
    }

    @Test
    public void create01() throws KeeperException, InterruptedException {
        //OPEN_ACL_UNSAFE  world:anyone:cdrwa
        zooKeeper.create("/test01", "test01".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    @Test
    public void create02() throws KeeperException, InterruptedException {
        //READ_ACL_UNSAFE  world:anyone:r
        zooKeeper.create("/test02", "test02".getBytes(), ZooDefs.Ids.READ_ACL_UNSAFE, CreateMode.PERSISTENT);
    }
}