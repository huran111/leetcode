package com.hr.堆;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-02-18 14:47
 */
public class GCTest {
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();
        String a = "sdfsdfdsfsd";
        while (true) {
            list.add(a);
            a = a + a;
            i++;
            System.out.println(i);
        }

    }
}