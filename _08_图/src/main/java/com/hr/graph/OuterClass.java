package com.hr.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-01-17 16:20
 */
public class OuterClass {
    public static long OUTER_DATE = System.currentTimeMillis();
    public static int a = 1;
    static {
        System.out.println("外部类静态块加载时间：" + System.currentTimeMillis());
    }
    private Map<InnerStaticClass,InnerStaticClass> map=new HashMap<>();
    public OuterClass() {
        timeElapsed();
        System.out.println("外部类构造函数事件：" + System.currentTimeMillis());
    }
    public   void  add(){
        map.put(new InnerStaticClass(),new InnerStaticClass());
        map.put(new InnerStaticClass(),new InnerStaticClass());

    }
    private static class InnerStaticClass {
        static {
            System.out.println("内部类静态块加载时间：" + System.currentTimeMillis());
        }
        public static long INNER_STATIC_DATE = System.currentTimeMillis();

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }
    //单纯的为了耗时而已
    private void timeElapsed() {
        for (int i = 0; i < 10000000; i++) {
            int a = new Random(100).nextInt(), b = new Random(100).nextInt();
            a = a + b;
        }
    }

    public static void main(String[] args) {
        System.out.println("内部类静态变量加载时间：" + InnerStaticClass.INNER_STATIC_DATE );
        System.out.println("外部类静态变量加载时间：" + OuterClass.OUTER_DATE );

        System.out.println("-==========================");
       new  OuterClass();
        System.out.println("-==========================");
        new  OuterClass();
    }
}