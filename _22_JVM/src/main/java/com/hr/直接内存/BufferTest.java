package com.hr.直接内存;

import java.nio.ByteBuffer;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-02-24 20:47
 */
public class BufferTest {
    private static final  int BUFFER=1024*1024*1024;

    public static void main(String[] args) {
        ByteBuffer byteBuffer=ByteBuffer.allocateDirect(BUFFER);
        try {
            Thread.sleep(20_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        byteBuffer=null;
    }
}