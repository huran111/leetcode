package 字符串;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-06 14:10
 */
public class InternTest {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3;
        String s1 = String.format("%d%d%d", a, b, c);
        String s2 = String.format("%d%d%d", a, b, c);
        String s3=s1.intern(); //此时常量池没有123 会加入常量池
        String s4=s2.intern();//此时常量池有123 返回改地址
        String s5="123";
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s3);//true
        System.out.println(s1 == s4);//true
        System.out.println(s1 == s5);//true
    }
}