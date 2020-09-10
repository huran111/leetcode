package 正则;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-07 22:11
 */
public class RegexTest {
    public static void main(String[] args) {
        String tgegex="[bct]at";
        "bat".matches(tgegex);//true
         String r="\\d{4,}";
        System.out.println("1234555".matches(r));

    }
}