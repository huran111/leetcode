package com.hr.虚拟机栈;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-02-16 19:02
 */
public class OperandStackTest {
    public static void main(String[] args) {

    }

    public int testAddOperator() {
        byte i = 23;
        int j = 23;
        int k = i + j;
        return k;
    }

    public void add() {
        int i1 = 10;
        i1++;
        int i2 = 20;
        ++i2;

        int i3 = 10;
        int i4 = i3++;
        int i5 = 10;
        int i6 = ++i5;

        int i7 = 10;
        i7 = i7++;

        int i8 = 10;
        i8 = ++i8;

        int i9 = 10;
        int i10 = i9++ + ++i9;
    }
}