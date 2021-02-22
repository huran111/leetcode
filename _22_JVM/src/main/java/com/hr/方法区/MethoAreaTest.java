package com.hr.方法区;

/**
 * @program: leetcode
 * @description: jdk8: -XX:MetaspaceSize=10m XX:MaxMetaspaceSize=100m
 * @author: HuRan
 * @create: 2021-02-21 21:16
 */
public class MethoAreaTest {
    public static void main(String[] args) {
        System.out.println("00000");
        try {
            Thread.sleep(100_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}