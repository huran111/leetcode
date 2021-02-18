package com.hr.堆;

import java.util.ArrayList;
import java.util.Random;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-02-18 14:18
 */
public class HeapInstanceTest {
    byte[] buffer = new byte[new Random().nextInt(1024 * 100)];

    public static void main(String[] args) {
        ArrayList<HeapInstanceTest>list=new ArrayList();
        while (true){
            list.add(new HeapInstanceTest());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}