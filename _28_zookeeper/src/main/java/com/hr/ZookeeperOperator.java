package com.hr;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-13 14:34
 */
public class ZookeeperOperator {
    ZooKeeper zooKeeper;

    @Before
    public void before() throws IOException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        zooKeeper = new ZooKeeper("39.106.69.95:2181,39.106.69.95:2182,39.106.69.95:2183", 500, new Watcher() {
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
    //更新节点
    @Test
    public void update(){
        //-1 代表不参与更新
        try {
            final Stat stat = zooKeeper.setData("/test01", "huran".getBytes(), -1);
            final int aversion = stat.getAversion();
            System.out.println(aversion);
            final long ctime = stat.getCtime();
            System.out.println("ctime:" + ctime);
            final long czxid = stat.getCzxid();
            System.out.println("czxid:" + czxid);
            final int dataLength = stat.getDataLength();
            System.out.println("dataLength:" + dataLength);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //更新节点
    @Test
    public void update2() throws KeeperException, InterruptedException {
        zooKeeper.setData("/test01", "huran3".getBytes(), -1, new AsyncCallback.StatCallback() {
            @Override
            public void processResult(int rc, String path, Object ctx, Stat stat) {
                System.out.println(rc);//0代表修改成功
                System.out.println(path);//节点的路径
                System.out.println(ctx);//上下文对象
                System.out.println(stat.getVersion());//版本
            }
        },"I am Context");
    }

    //删除节点
    @Test
    public void delete() throws KeeperException, InterruptedException {
        // -1 版本参数不作为删除条件
        this.zooKeeper.delete("/test01",-1);
    }
    //删除节点
    @Test
    public void delete2() throws KeeperException, InterruptedException {
        // -1 版本参数不作为删除条件
        this.zooKeeper.delete("/test01", -1, new AsyncCallback.VoidCallback() {
            @Override
            public void processResult(int rc, String path, Object ctx) {
                System.out.println(rc);
                System.out.println(path);
                System.out.println(ctx);
            }
        },"I am Context");
    }

    //读取数据
    @Test
    public void getData() throws KeeperException, InterruptedException {
        Stat stat=new Stat();
        final byte[] data = zooKeeper.getData("/get/node1", false, stat);
        final String s = new String(data);
        System.out.println(s);
        System.out.println(stat.getVersion());
    }

    //读取数据
    @Test
    public void getData2() throws KeeperException, InterruptedException {
        zooKeeper.getData("/get/node1", false, new AsyncCallback.DataCallback() {
            @Override
            public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
                System.out.println(rc);
                System.out.println(path);
                System.out.println(ctx);
                System.out.println(new String(data));
                System.out.println(stat.getVersion());
            }
        },"I am context");
    }
    //查看子节点
    @Test
    public void  getChildData() throws KeeperException, InterruptedException {
        final List<String> children = zooKeeper.getChildren("/test/node1", false);

        for (String child : children) {
            System.out.println(child);
        }
    }

    //查看子节点
    @Test
    public void  getChildData2() throws KeeperException, InterruptedException {
        zooKeeper.getChildren("/test/node1", false
                , new AsyncCallback.ChildrenCallback() {
                    @Override
                    public void processResult(int rc, String path, Object ctx, List<String> children) {
                        System.out.println(rc);
                        System.out.println(path);
                        System.out.println(ctx);
                        System.out.println(children.toString());
                    }
                },"I am Context");
    }
    //判断节点是否存在
    @Test
    public void exiets() throws KeeperException, InterruptedException {
        final Stat exists = zooKeeper.exists("/aaa", false);
        System.out.println(exists);
    }
    //判断节点是否存在
    @Test
    public void exiets2() throws KeeperException, InterruptedException {
        zooKeeper.exists("/aaa", false, new AsyncCallback.StatCallback() {
            @Override
            public void processResult(int rc, String path, Object ctx, Stat stat) {
                System.out.println(rc);
                System.out.println(path);
                System.out.println(stat);
            }
        },"T am ");
    }
}