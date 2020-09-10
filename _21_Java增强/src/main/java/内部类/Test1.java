package 内部类;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-05 15:23
 */
public class Test1 {
    {
        System.out.println("第一构造块");
    }
    public Test1(int i) {

        System.out.println("第" + i + "次调用" + "构造方法");
    }

    {
        System.out.println("第二构造块");
    }

    public static  void  main(String[] args) {
        new Test1(0);
        new Test1(1);
        new Test1(2);

    }

}