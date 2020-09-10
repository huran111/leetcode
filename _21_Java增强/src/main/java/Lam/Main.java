package Lam;

import 内部类.Test;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-06 13:27
 */
public class Main {
    public static void main(String[] args) {
        Testable t=Math::hypot;
        System.out.println(t.test(1, 2));

    }
}