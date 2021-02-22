package com.hr.方法区;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * @program: leetcode
 * @description: 方法区溢出:-XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 * @author: HuRan
 * @create: 2021-02-21 21:30
 */
public class JavaMethodAreaOom extends ClassLoader {
    public static void main(String[] args) {
        int j = 0;
        try {
            JavaMethodAreaOom o = new JavaMethodAreaOom();
            for (int i = 0; i < 10000; i++) {
                ClassWriter classWriter = new ClassWriter(0);
                classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                byte[] bytes = classWriter.toByteArray();
                o.defineClass("Class" + i, bytes, 0, bytes.length);
                j++;
            }
        } finally {
            System.out.println(j);
        }
    }
}