package Lam;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-12 22:45
 */
public class LambadaTest {
    @Test
    public void test01() {
        Consumer consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("胡冉");
        Consumer<String> con = (String s) -> {
            System.out.println(s);
        };
        con.accept("A");
    }

    //左边只有一个参数时 括号省略
    @Test
    public void test2(){
        Consumer<String> con =  s -> {
            System.out.println(s);
        };
        con.accept("A");
    }
    //需要2个或者以上的参数 有返回值
    @Test
    public void test3(){
        Comparator<Integer> com2=(o1,o2)->{
            System.out.println("-----");
            return  o1.compareTo(o2);
        };
        final int compare = com2.compare(12, 23);
        System.out.println(compare);
    }
}