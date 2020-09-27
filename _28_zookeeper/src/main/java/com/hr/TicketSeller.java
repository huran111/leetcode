package com.hr;

import org.apache.zookeeper.KeeperException;

import java.util.concurrent.TimeUnit;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-16 22:48
 */
public class TicketSeller {
    private void sell(){
        System.out.println("售票开始");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("售票结束");
    }

    public void sellTicketWithLock() throws KeeperException, InterruptedException {
        ZookeeperLock lock=new ZookeeperLock();
        lock.acquireLock();
        sell();
        lock.releaseLock();
    }

    public static void main(String[] args) throws KeeperException, InterruptedException {
        TicketSeller ticketSeller=new TicketSeller();
        for (int i = 0; i < 10; i++) {
            ticketSeller.sellTicketWithLock();
        }
    }
}