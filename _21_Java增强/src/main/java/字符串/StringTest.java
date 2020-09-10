package 字符串;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-06 14:05
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "mj";
        String s2 = new String("mj");
        String s3 = new String(s1);
        String s4 = new String(s2);
        char[] cs = {'m', 'j'};
        String s5 = new String(cs);
        String s6 = new String(s5);
        System.out.println();

    }
}