package com.hr.虚拟机栈;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-02-16 19:51
 */
public class DynamicLinkingTest {
    int num = 10;

    public static void main(String[] args) {


    }

    public void methodA() {
        System.out.println("methodA");
    }

    public void methodB() {

        System.out.println("methodB");
        methodA();
        num++;
    }
}