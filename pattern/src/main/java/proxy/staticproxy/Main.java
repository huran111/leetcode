package proxy.staticproxy;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-27 22:01
 */
public class Main {
    public static void main(String[] args) {
        Father father=new Father(new Son());
        father.findLove();
    }
}