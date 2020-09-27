package com.hr;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @program: leetcode
 * @description: 配置信息
 * @author: HuRan
 * @create: 2020-09-16 22:02
 */
public class ZookeeperMeta implements Watcher {
    CountDownLatch countDownLatch = new CountDownLatch(1);
    static ZooKeeper zooKeeper;

    private String url;
    private String username;
    private String password;

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Watcher.Event.KeeperState.SyncConnected) {
            System.out.println("连接创建成功");
            countDownLatch.countDown();
        } else if (watchedEvent.getState() == Watcher.Event.KeeperState.Disconnected) {
            System.out.println("断开连接");
        } else if (watchedEvent.getState() == Watcher.Event.KeeperState.Expired) {
            System.out.println("会话超时");
            try {
                zooKeeper = new ZooKeeper("39.106.69.95:2181", 500, new ZookeeperWatch());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (watchedEvent.getState() == Watcher.Event.KeeperState.AuthFailed) {
            System.out.println("认证失败");
        } else if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
            //配置信息发生变化
            initValue();
        }
    }

    public ZookeeperMeta() {
        initValue();
    }

    //连接zookeeper服务器信息
    public void initValue() {
        try {
            zooKeeper = new ZooKeeper("39.106.69.95:2181", 5000, this);
            countDownLatch.await();
            this.url = new String(zooKeeper.getData("/config/url", true, null));
            this.url = new String(zooKeeper.getData("/config/username", true, null));
            this.url = new String(zooKeeper.getData("/config/password", true, null));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}