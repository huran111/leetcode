package 接口.demo01;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-05 21:51
 */
public class Dragon implements Fly,Fire {
    public static void main(String[] args) {
        Dragon dragon=new Dragon();
        System.out.println(dragon.myself());
    }
}