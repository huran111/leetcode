package 反射;

import 注解.MaAnnation;

import java.util.Comparator;

/**
 * @program: java_suanfa
 * @description:
 * @author: HuRan
 * @create: 2020-09-11 11:10
 */
@MaAnnation(value = "hello")
public class Person extends Creature<String> implements Comparable<String> {
    @MaAnnation(value = "name")
    public String name;
    public Integer age;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    private Person(Integer age) {
        this.age = age;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() throws Exception {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    @MaAnnation(value = "show")
    public String show(String a) {
        System.out.println("展示自我"+a);
        return  a;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void eat() {
        System.out.println("人吃");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}