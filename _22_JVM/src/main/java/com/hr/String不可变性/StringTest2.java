package com.hr.String不可变性;

import org.junit.Test;

/**
 * @program: leetcode
 * @description: String不可变性
 * @author: HuRan
 * @create: 2021-02-25 20:36
 */
public class StringTest2 {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest2 s = new StringTest2();
        s.change(s.str, s.ch);
        System.out.println(s.str);//good
        System.out.println(s.ch);// best
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
}