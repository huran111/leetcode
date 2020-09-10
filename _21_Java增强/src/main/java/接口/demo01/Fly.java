package 接口.demo01;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-05 21:51
 */
public interface Fly  extends Animal{
    @Override
    default String myself() {
        return "i am an fly";
    }
}