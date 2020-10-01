package java8.demo01;

/**
 * @program: java8-api
 * @description:
 * @author: HuRan
 * @create: 2020-09-08 18:12
 */
@FunctionalInterface
public interface ApplePredicate {
    boolean test(Apple apple);
}