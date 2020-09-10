package 接口.demo03;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-05 22:23
 */
public class Teacher extends Person {
    public int age = 3;

    @Override
    public int getPAge() {
        return age;
    }

    public int getTAge() {
        return age;
    }
}