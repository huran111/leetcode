package 代码块;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-08 22:24
 */

/**
 * 1.代码块的作用:
 */
public class Person {
    public static void main(String[] args) {
        Person person=new Person();
        Person person2=new Person();

    }
    //只会执行一次
    static {
        System.out.println("static blocked.");
    }
    {
        System.out.println("block");
    }
    String name;
    int age;
    static String desc = "我是一个人";

    public Person() {
        System.out.println("我是构造函数");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println("吃");
    }
}