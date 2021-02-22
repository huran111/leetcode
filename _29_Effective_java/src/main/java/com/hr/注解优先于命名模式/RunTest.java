package com.hr.注解优先于命名模式;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-02-22 21:40
 */
public class RunTest {
    public static void main(String[] args) throws ClassNotFoundException {
        int tests=0;
        int passed=0;
        Class<?> testClass=Class.forName("com.hr.注解优先于命名模式.Sample");
        for (Method m : testClass.getDeclaredMethods()) {
            if(m.isAnnotationPresent(Test.class)){
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (Exception e) {
                    System.out.println(m + " failed " + e.getCause());
                }
            }
        }
        System.out.printf("Passed:%d ,Failed: %d\n",passed,tests-passed);
    }
}