package 静态变量;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-08 22:00
 */

/**
 * 静态变量：
 * 1.我们 创建了类的多个对象，多个对象共享同一个静态变量，当通过某一个对象修改静态变量时，会导致
 * 其他对象调用次静态变量的时候，是想修改过了的。
 * 2.静态变量随着类的加载而加载
 * 3.静态变量的加载要早于类的加载
 * 3.由于类只会加载一次，所以静态变量内存中也会只存在一份，存在方法区中的静态域中
 * 4.变量即类变量，位于方法区，为所有该类下的对象共享，共享一份内存，一旦静态变量被修改，其他对象均对修改可见，故线程非安全。
 * 5.与静态成员变量一样，属于类本身，在类装载的时候被装载到内存（Memory），不自动进行销毁，会一直存在于内存中，直到JVM关闭。
 * 6.静态方法随着类的加载而加载
 */
public class StaticTest {
    public static void main(String[] args) {
        Chinese var1 = new Chinese();
        var1.name = "hr";
        var1.s1 = "s1";
        var1.action = "A";
        Chinese var2 = new Chinese();
        var2.name = "hr";
        var2.s1 = "s1";
        var2.action = "B";
        Chinese.action = "中国";
        final Man man = new Man();
        Man.action = "河南";
        System.out.println(var1.action);
    }
}

class Chinese {
    String name;
    String s1;
    static String action;

    public static void show() {
        System.out.println("中国人");
    }
    public void info(){
        System.out.println(name + s1);
    }
}

class Man {
    static String action;
}