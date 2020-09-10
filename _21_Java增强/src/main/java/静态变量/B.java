package 静态变量;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-08 22:13
 */
public class B extends A {
    //B中的静态成员na会覆盖A中的静态成员，此时，A和B拥有完全不同的静态成员na。
    public  static int na;
    public static void main(String[] args) {
        //继承之后可以继承父类的静态成员变量。并且A.na \ a.na \ B.na \ b.na 代表的是同一个变量
        A.na=3;
       A a=new A();
       a.na++;
        System.out.println(A.na);
        B b=new B();
        b.na++;
        System.out.println(b.na);
        System.out.println(A.na);
    }
}