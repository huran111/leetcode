package com.hr.方法绑定机制;

import com.sun.media.jfxmediaimpl.HostUtils;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-02-16 20:08
 */
class Animal {
    public void eat() {
        System.out.println("动物吃饭");
    }
}

interface Huntable {
    void hunt();
}

class Dog extends Animal implements Huntable {

    @Override
    public void hunt() {
        System.out.println("多管闲事");
    }

    @Override
    public void eat() {
        super.eat();//早期绑定
        System.out.println("狗吃骨头");
    }
}

class Cat extends Animal implements Huntable {
    private static final String s="sd";
    public Cat() {
        super();
    }

    public Cat(String name) {
        this();
    }

    @Override
    public void hunt() {
        System.out.println("天经地义");
    }
    public static void test(){

    }
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}

public class AnimalTest {
    public void showAnimal(Animal animal) {
        animal.eat();//晚期绑定
    }

    public void showHunt(Huntable huntable) {
        huntable.hunt();//晚期绑定
    }
}