package 内部类;

import java.util.function.Function;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-05 14:04
 */
public class Person {
    private int age;

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {

    }
    private static int count = 1;

    private static void run() {

    }

    //静态内部类
    // 可以直接访问外部类中的除实例变量和实例方法外的其他成员包括private
    //可以访问 私有age但必须new Person();
    public static class Car {
        public void run() {
            Person  person=new Person();
            System.out.println(person.age);
            System.out.println(Person.count);
            Person.run();
        }
    }

    //内部类
    //1 不可以定义static成员
    //2 除非是编译时常量 编译时期就确定的
    //3 内部类可以访问外部类中的所有成员包括private
    //4 外部类也可以访问内部类的成员变量和成员方法包括private
    public class Hand {
        private int weight;
        ///private  static  int age=1; 不行
        private static final int aaa = 0; // 可以
    }

    public void test(){
        System.out.println("test");
        {
            System.out.println("block");
        }
    }
}