package 接口.demo01;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-05 21:49
 */
public interface Animal {
    default String myself(){
        return " i am an animal";
    }
}