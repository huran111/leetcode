package com.hr.String不可变性;

import org.junit.Test;

/**
 * @program: leetcode
 * @description: String不可变性
 * @author: HuRan
 * @create: 2021-02-25 20:36
 */
public class StringTest1 {
    public static void main(String[] args) {
        String s1 = "abc";//字符串常量池
        String s2 = "abc";//字符串常量池  此时字符串常量池中已经有了abc返回地址引用
        s1 = "hello"; //返回新的地址引用
        System.out.println(s1 == s2); //判断地址

        System.out.println(s1);
        System.out.println(s2);
    }

    @Test
    public void test2() {
        String s1 = "abc";
        String s2 = "abc";
        s2 += "def";
        System.out.println(s2); //abcdef
        System.out.println(s1); //abc
    }

    @Test
    public void test02() {
        String s1 = "abc";
        String s2 = s1.replace('a', 'A');
        System.out.println(s1);//abc
        System.out.println(s2); //Abc
    }
    @Test
    public void test03(){
        String s=new String("abc");
        String s2="abc";
        System.out.println(s == s2);
        String intern = s.intern();
        System.out.println(intern);
        System.out.println(s2 == intern);
    }
}