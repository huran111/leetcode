package com.hr;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-03 23:28
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<>();
        list.add(20);
        list.add(0,10);
        list.add(30);
        list.remove(1);
        list.add(list.size(),40);
        System.out.println(list.toString());
    }
}