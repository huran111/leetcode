package com.hr.逃逸分析;

/**
 * @program: leetcode
 * @description: 标量替换
 * -Xms100m -Xmx100m -XX:-DoEscapeAnalysis -XX:+PrintGCDetails -XX:-EliminateAllocations
 * @author: HuRan
 * @create: 2021-02-18 20:09
 */
public class ScalarReplace {
    public static class User{
        int id;
        String name;
    }
    public static void alloc(){
        User u=new User();
        u.id=4;
        u.name="sdfsd";
    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为:" + (end-l  ) + "ms");
        try {
            Thread.sleep(100_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}