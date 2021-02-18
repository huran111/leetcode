package com.hr.堆;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-02-18 12:28
 */
public class HeapSpaceInital {
    public static void main(String[] args) {
        long initMoney=Runtime.getRuntime().totalMemory()/1024/1024;
        //java 虚拟机试图使用最大堆内存
        long maxMemory=Runtime.getRuntime().maxMemory()/1024/1024;
        System.out.println("-Xms："+initMoney+ "M");
        System.out.println("-Xmx: "+maxMemory+" M");

//        try {
//            Thread.sleep(100_000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}