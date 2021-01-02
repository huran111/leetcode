package com.hr.test;

import java.util.LinkedList;
import java.util.List;

public class Main{
    public static void main(String[] args) {

        List<Integer> list=new LinkedList<>();
        list.add(0,12);
        list.add(0,23);
        System.out.println(list.size());
    }
}