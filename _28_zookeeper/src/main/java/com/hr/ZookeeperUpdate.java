package com.hr;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.RetryOneTime;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-17 22:30
 */
public class ZookeeperUpdate {
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
    public void set1(){

    }
}