package Lam;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-06 13:29
 */
public class Person {
    public void setAge(int age) {
        System.out.println("person age:" + age);
    }

    @FunctionalInterface
    public interface Testable2 {
        void test(int v);
    }

    static void execute(Testable2 t, int v) {
        t.test(v);
    }

    public static void main(String[] args) {
        execute(v -> System.out.println(v), 10);
        execute(System.out::println, 10);
        execute(new Person()::setAge, 20);
    }
}