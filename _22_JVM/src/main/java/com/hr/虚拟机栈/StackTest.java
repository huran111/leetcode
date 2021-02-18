package com.hr.虚拟机栈;

/**
 * @program: leetcode
 * @description: -Xss 设置栈大小
 * @author: HuRan
 * @create: 2021-02-16 11:30
 */
public class StackTest {
    private static int count=1;
    public static void main(String[] args) {
        System.out.println(count);
        count++;
        StackTest.main(args);
    }
    public void methodA(){
        int i=10;
        int j=20;
        methodB();
    }

    private void methodB() {
        int i=30;
        int j=40;
    }
}