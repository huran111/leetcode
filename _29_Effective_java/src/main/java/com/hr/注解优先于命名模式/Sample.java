package com.hr.注解优先于命名模式;

import javax.management.relation.RoleUnresolved;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-02-22 21:37
 */
public class Sample {
    @Test
    public static void m1(){

    }
    @Test
    public static void m2(){
        throw  new RuntimeException("s");
    }

    public static void m4(){}

    @Test
    public void m5(){}

    public static void m6(){

    }
    @Test
    public static void m7(){
        throw  new RuntimeException("s");
    }
}