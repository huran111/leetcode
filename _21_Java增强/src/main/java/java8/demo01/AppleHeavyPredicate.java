package java8.demo01;

/**
 * @program: java8-api
 * @description:
 * @author: HuRan
 * @create: 2020-09-08 18:13
 */
public class AppleHeavyPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight()>150;
    }
}