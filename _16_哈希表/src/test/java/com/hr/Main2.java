package com.hr;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-02-14 14:02
 */
public class Main2 {
    public static void main(String[] args) {
//        String s = "jack";
//        int length = s.length();
//        int hashcode = 0;
//        for (int i = 0; i < length; i++) {
//            char c = s.charAt(i);
//            //hashcode = hashcode * 31 + c;
//            hashcode=(hashcode<<5)-hashcode+c;
//        }
//        System.out.println(s.hashCode());
//        //3254239
//        //3254239
//        int a=100;
//        System.out.println(Integer.hashCode(a));
//        float b=10.4f;
//        System.out.println(Float.hashCode(b));
//        double d=23.44;
//        System.out.println(Double.hashCode(d));
//        System.out.println(hashcode);
//        Integer aValue =10;
//        show(aValue);
//        Integer leftMoveValue1 =aValue <<1; //左移1位
//        show(leftMoveValue1);
//        Integer leftMoveValue2 =aValue <<2; //左移2位
//        show(leftMoveValue2);
//        Integer leftMoveValue3 =aValue <<2;//左移3位
//        show(leftMoveValue3);
//        Integer aValue =10;
//        show(aValue);
//        Integer leftMoveValue1 =aValue >>1; //右边移1位
//        show(leftMoveValue1);
//        Integer leftMoveValue2 =aValue >>2; //右移2位
//        show(leftMoveValue2);
//        Integer leftMoveValue3 =aValue >>2;//右移3位
//        show(leftMoveValue3);
        Integer aValue =-10;
        show(aValue);
        Integer leftMoveValue1 =aValue >>>1; //无符号右边移1位
        show(leftMoveValue1);
        Integer leftMoveValue2 =aValue >>>2; //无符号右移2位
        show(leftMoveValue2);
        Integer leftMoveValue3 =aValue >>>3;//无符号右移3位
        show(leftMoveValue3);
    }
    /**
     * 打印数字对应的二进制字符串
     * @param number
     */
    public static void show(Integer number)
    {
        //打印原值
        System.out.println(number);
        //打印值对应的二进制
        System.out.println(Integer.toBinaryString(number));
    }
}
