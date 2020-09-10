package 内部类;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-05 14:05
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        //内部类实例是不能单独创建的
        final Person.Hand hand = person.new Hand();
        person.test();
    }
}