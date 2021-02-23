package com.hr.注解优先于命名模式;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-02-22 21:50
 */
public class Sapmle2 {
    @ExceptionTest(ArithmeticException.class)
    public static void m1() {
        int i = 0;
        i = i / i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2() {
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3() {

    }
    @ExcetionTest02({IndexOutOfBoundsException.class,NullPointerException.class})
    public static void doubleBad(){
        List<String> list=new ArrayList<>();
        list.addAll(5,null);
    }
    //可重复注解
    @ExceptionRepeatableTest(IndexOutOfBoundsException.class)
    @ExceptionRepeatableTest(NullPointerException.class )
    public static void doubleBad2(){
        List<String> list=new ArrayList<>();
        list.addAll(5,null);
    }
    //可重复注解  会产生一个包含注解类型的合成注解， 为了利用isAnnotationPresent检测，检测重复和非重复注解，必须检查注解类型及其包含的注解类型
    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("com.hr.注解优先于命名模式.Sapmle2");
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionRepeatableTest.class) || m.isAnnotationPresent(ExceptionRepeatableCOntainer.class)) {
                try {
                    m.invoke(null);
                } catch (InvocationTargetException | IllegalAccessException e) {
                    Throwable cause = e.getCause();
                    //getAnnotationsByType 可用于访问重注解和非重复注解
                    ExceptionRepeatableTest[] annotationsByType = m.getAnnotationsByType(ExceptionRepeatableTest.class);
                    for (ExceptionRepeatableTest x : annotationsByType) {
                        if (x.value().isInstance(cause)) {
                            passed++;
                        } else {

                        }
                    }

                    System.out.println(m + " failed " + e.getCause());
                }
            }
        }
        System.out.printf("Passed:%d \n",passed);

    }
//    public static void main(String[] args) throws ClassNotFoundException {
//        int tests = 0;
//        int passed = 0;
//        Class<?> testClass = Class.forName("com.hr.注解优先于命名模式.Sapmle2");
//        for (Method m : testClass.getDeclaredMethods()) {
//            if (m.isAnnotationPresent(ExceptionTest.class)) {
//                try {
//                    m.invoke(null);
//                } catch (InvocationTargetException | IllegalAccessException e) {
//                    Throwable cause = e.getCause();
//                    Class<? extends Throwable> value = m.getAnnotation(ExceptionTest.class).value();
//                    if (value.isInstance(cause)) {
//                        passed++;
//                    } else {
//                        System.out.println(value.getName());
//                        System.out.println(cause);
//                    }
//                    System.out.println(m + " failed " + e.getCause());
//                }
//            }
//        }
//        System.out.printf("Passed:%d \n",passed);
//
//    }
}