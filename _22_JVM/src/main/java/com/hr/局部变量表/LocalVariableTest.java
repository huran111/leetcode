package com.hr.局部变量表;

import java.util.Date;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-02-16 16:23
 */
public class LocalVariableTest {
    private int count = 0;

    public static void main(String[] args) throws Exception {
        LocalVariableTest test = new LocalVariableTest();
        int num = 10;
        test.test01();
    }

    public static void testStatic() {
        LocalVariableTest test = new LocalVariableTest();
        Date date = new Date();
        int count = 10;
        System.out.println(count);
        //this方法不存在于当前对象的局部变量表中
        //System.out.println(this.count);
    }

    private void test01() {
        Date date = new Date();
        String name1 = "huran";
    }

    private void test02() {
        Date date = new Date();
        double weight = 23.43;
        String name1 = "huran";
    }

    public void test04() {
        int a = 0;
        {
            int b = 0;
            b = a + 1;//
        }
        int c = a + 1; //c只用的之前b的slot,
    }
    //变量分类：1.基本数据类型，2.引用数据类型
    /**
     * 1.成员变量：
     *  类变量 linking的prepare阶段：给类变量默认赋值，在initail阶段：给类变量显示赋值
     *  实例变量 :随着对象的创建，在堆空间中分配实例变量，并进行默认赋值
     * 2.局部变量:在使用前必须显示赋值，否则编译不通过
     */
    public void test05(){
        int num = 0;
        System.out.println(num);
    }

}