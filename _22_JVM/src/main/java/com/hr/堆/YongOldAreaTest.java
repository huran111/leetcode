package com.hr.堆;

/**
 * @program: leetcode
 * @description: 大对象直接进入老年代
 * -Xms60m -Xmx60m -XX:NewRatio=2 -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * @author: HuRan
 * @create: 2021-02-18 14:58
 */
public class YongOldAreaTest {
    public static void main(String[] args) {
        byte[] buf = new byte[1024 * 1024 * 20];
    }
}