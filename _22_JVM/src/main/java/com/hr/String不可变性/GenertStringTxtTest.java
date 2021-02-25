package com.hr.String不可变性;

import java.io.FileWriter;
import java.io.IOException;

import static javax.swing.UIManager.getString;

/**
 * @program: leetcode
 * @description:
 * <p>
 *     -XX:StringTableSize=1009
 *     -XX:StringTableSize=60021
 *     String.intern()字符串常量池中没有则生成
 * </p>
 * @author: HuRan
 * @create: 2021-02-25 20:48
 */
public class GenertStringTxtTest {
    public static void main(String[] args) throws IOException {
test();
    }
    public   static void test() throws IOException {
        FileWriter fw=new FileWriter("word.txt");
        for (int i = 0; i < 100000; i++) {
            int leb=(int)(Math.random()*(10-1+1)+1);
            fw.write(getStrings(leb)+"\n");
        }
        fw.close();
    }

    private static String getStrings(int leb) {
        String str="";
        for (int i = 0; i < leb; i++) {
            int num=(int)Math.random()*(90-65)+(int)(Math.random()*2)*32;
            str+=(char)num;
        }
        return str;
    }
}