package com.hr;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.retry.RetryOneTime;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-17 22:30
 */
public class ZookeeperCreate {
    CuratorFramework client;
    @Before
    public void before(){
         client= CuratorFrameworkFactory.builder()
                .connectString("39.106.69.95:2181,39.106.69.95:2182,39.106.69.95:2183")
                .sessionTimeoutMs(5000)
                .retryPolicy(new RetryOneTime(3000))
                .namespace("cccc")
                .build();
        client.start();
    }
    @After
    public void after(){
        client.close();
    }
    @Test
    public void create1() throws Exception {
        client.create()
                .withMode(CreateMode.PERSISTENT)
                .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
                .forPath("/huran","huran".getBytes());
        System.out.println("结束");
    }
    @Test
    public void create2() throws Exception {
        List<ACL> list=new ArrayList<>();
        Id id =new Id("ip","39.106.69.95");
        list.add(new ACL(ZooDefs.Perms.ALL,id));
        client.create().withMode(CreateMode.PERSISTENT).withACL(list)
                .forPath("/huran2","node2".getBytes());
        System.out.println("结束");

    }
    //递归创建节点
    @Test
    public void create3() throws Exception {
        client.create().creatingParentsIfNeeded()
                .withMode(CreateMode.PERSISTENT)
                .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
                .forPath("/huran3/mode","hhh".getBytes());
        System.out.println("结束");
    }
    //异步的方式创建
    @Test
    public void create4() throws Exception {
        client.create()
                .withMode(CreateMode.PERSISTENT)
                .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
                .inBackground(new BackgroundCallback() {
                    @Override
                    public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                        System.out.println(client.getNamespace());
                        System.out.println(event.getPath());
                        System.out.println(event.getType());
                        System.out.println(event.getData());
                    }
                }).forPath("/node5","node4".getBytes());
        Thread.sleep(5000);
        System.out.println("结束");
    }
    public static void main(String[] args) {

    }
}