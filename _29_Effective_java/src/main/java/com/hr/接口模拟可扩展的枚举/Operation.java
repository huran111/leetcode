package com.hr.接口模拟可扩展的枚举;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-02-22 21:15
 */
@FunctionalInterface
public interface Operation {
    double apply(double x, double y);
}