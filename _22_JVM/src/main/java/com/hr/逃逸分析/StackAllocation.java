package com.hr.逃逸分析;

/**
 * @program: leetcode
 * @description: 栈上分配
 * -Xms100m -Xmx100m -XX:-DoEscapeAnalysis -XX:+PrintGCDetails
 * @author: HuRan
 * @create: 2021-02-18 19:39
 */
public class StackAllocation {
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

    private static void alloc() {
        User user = new User();//未发生逃逸
    }

    static class User {

    }
}