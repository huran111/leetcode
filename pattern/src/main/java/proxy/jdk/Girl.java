package proxy.jdk;

import proxy.staticproxy.Person;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-27 22:18
 */
public class Girl implements Person {
    @Override
    public void findLove() {
        System.out.println("高富帅");
    }
}