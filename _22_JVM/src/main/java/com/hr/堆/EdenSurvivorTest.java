package com.hr.堆;

/**
 * @program: leetcode
 * @description: -Xms600m -Xmx600m
 * -XX:-UseAdaptiveSizePolicy 关闭自适应比例
 * -XX:SurvivorRatio=8 设置新生代中Eden区和Survivor区的比例
 * -Xmn:设置新生代的空间的大小 （一般不设置）
 * @author: HuRan
 * @create: 2021-02-18 13:11
 */
public class EdenSurvivorTest {
    public static void main(String[] args) {
        try {
            Thread.sleep(1000_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}