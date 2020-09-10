package 内部类;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-05 15:22
 */
public class Test {
    public
    static void main(String[] args) {
        {
            int x = 3;
            System.out.println("普通代码块内的变量x=" + x);
        }

        int x = 1;
        System.out.println("主方法内的变量x=" + x);
        {
            int y = 7;
            System.out.println("普通代码块内的变量y=" + y);
        }

    }

}