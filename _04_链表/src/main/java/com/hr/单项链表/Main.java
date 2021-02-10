package com.hr.单项链表;

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
        list.add(25);
        list.add(30);

        System.out.println(list.toString());
        LinkedList02<Integer> list2=new LinkedList02<>();
        list2.add(20);
        list2.add(0,10);
        list2.remove(1);
        System.out.println(list2.size);
        System.out.println(list2.toString());

    }

}