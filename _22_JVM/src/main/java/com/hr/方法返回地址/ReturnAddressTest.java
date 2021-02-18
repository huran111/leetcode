package com.hr.方法返回地址;

import java.io.FileReader;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-02-17 19:22
 */
public class ReturnAddressTest {
    public static void main(String[] args) {

    }

    public boolean methodBoolean() {
        return false;
    }

    public Integer methodInt() {
        return 1;
    }

    public Long methodLong() {
        return 1L;
    }
    public long methodlong() {
        return 1L;
    }

    public byte methodByte() {
        return 1;
    }
    native public void taaa();
    public void method2() {
        try {
            methodVoid();
            method01();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void methodVoid() {

    }

    public void method01() throws Exception {
        FileReader fis = new FileReader("huran.txt");
        char[] buffer = new char[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            String str = new String(buffer, 0, len);
            System.out.println(str);
        }
        fis.close();
    }

}