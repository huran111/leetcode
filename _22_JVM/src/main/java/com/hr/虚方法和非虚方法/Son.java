package com.hr.虚方法和非虚方法;

/**
 * @program: leetcode
 * @description: 虚方法和非虚方法
 * @author: HuRan
 * @create: 2021-02-16 20:21
 */
class Father {
    public Father() {
        System.out.println("father的构造器");
    }

    public static void showStatic(String str) {
        System.out.println("father " + str);
    }

    public final void showFinal() {
        System.out.println("father show final");
    }

    public void showCommon() {
        System.out.println("son 普通方法");
    }
}

public class Son    extends Father {
    public Son(){
        super();
    }
    public Son(int age){
        this();
    }
    public static void showStatic(String str) {
        System.out.println("son " + str);
    }
    private void showPrivate(String str){
        System.out.println("showPrivate " + str);
    }
    public void show(){
        showStatic("huran");
        Father.showStatic("aaa");
        showPrivate("hello");
        super.showCommon();
        showFinal();
        showCommon();
        infos();
    }

    private void infos() {
    }

    public static void main(String[] args) {
        Son son=new Son();
        son.show();
    }
}