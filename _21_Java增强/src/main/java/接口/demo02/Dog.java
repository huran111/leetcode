package 接口.demo02;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-05 22:04
 */
public class Dog extends Animal {
    public static void run(){
        System.out.println("Dog run");
    }
    @Override
    public void run2(){
        System.out.println("Dog run2");

    }
}