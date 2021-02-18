package com.hr.逃逸分析;

/**
 * @program: leetcode
 * @description: 同步消除
 * @author: HuRan
 * @create: 2021-02-18 20:05
 */
public class SynchronizedTest {
    public void f(){
        Object o=new Object();
        synchronized (o){
            System.out.println(o);
        }
    }
}