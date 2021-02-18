package com.hr.虚方法和非虚方法;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-02-16 20:37
 */
@FunctionalInterface
interface Func {
   void func(String stgr);
}

public class LamdbaTest {
    public void lamdba(Func func){
        return;
    }
    public static void main(String[] args) {
        LamdbaTest lamdbaTest=new LamdbaTest();
        Func func
                =s->{
            System.out.println(s);
        };
        lamdbaTest.lamdba(func);
    }
}