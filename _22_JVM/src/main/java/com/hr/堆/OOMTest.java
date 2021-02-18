package com.hr.堆;

import java.util.ArrayList;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-02-18 12:55
 */
public class OOMTest {
    public static void main(String[] args) {
        ArrayList<Byte> list=new ArrayList<>();
        while (true){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new Byte((byte) 100));
            list.add(new Byte((byte) 100));
            list.add(new Byte((byte) 100));

            list.add(new Byte((byte) 100));
        }
    }
}