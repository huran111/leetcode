package 接口.demo03;

import 接口.demo02.Animal;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-05 22:18
 */
public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.age);//2
        System.out.println(student.getPAge());//1
        System.out.println(student.getSAge());//2
        Person student1 = new Student(); //实例属性 不存在多态的概念，只看左边是什么类型（Person）
        System.out.println(student1.age);//1
        System.out.println(student1.getPAge());
        System.out.println("==================================");
        Teacher teacher = new Teacher();
        System.out.println(teacher.age);//3
        System.out.println(teacher.getPAge());//3
        System.out.println(teacher.getTAge());//3
        Person teacher2 = new Teacher();
        System.out.println(teacher2.age);//1
        System.out.println(teacher2.getPAge());//3
        //如果是实例方法 存在多态行为，看右边
        Person person=new Person();
        if(person instanceof Student){
            System.out.println("1111");
        }
        if(student instanceof Person){
            System.out.println("11122221");
        }

    }
}