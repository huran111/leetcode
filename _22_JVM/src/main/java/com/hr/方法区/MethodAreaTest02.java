package com.hr.方法区;

/**
 * @program: leetcode
 * @description: no-final
 * @author: HuRan
 * @create: 2021-02-21 21:54
 */
public class MethodAreaTest02 {
    public static void main(String[] args) {
        Order o=null;
        o.hello();
        System.out.println(o.count);
    }
}
class  Order{
    public static int count=1;
    public static final  int number=2;
    public static void hello(){
        System.out.println("hello");
    }
}