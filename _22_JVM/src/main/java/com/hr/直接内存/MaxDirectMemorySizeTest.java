package com.hr.直接内存;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-02-24 20:55
 */
public class MaxDirectMemorySizeTest {
    public static void main(String[] args) {
        Field declaredField = Unsafe.class.getDeclaredFields()[0];

        declaredField.setAccessible(true);
        try {
            Unsafe o = (Unsafe)declaredField.get(null);
            while (true){
                o.allocateMemory(1024*1024);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}