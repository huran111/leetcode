package Lam;

import org.junit.Test;

import java.io.PrintStream;
import java.util.function.Consumer;
import java.util.function.Supplier;


/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-13 10:05
 */
public class MethodRefTest {
    public void test(){
        Consumer<String> con= str-> System.out.println(str);
        con.accept("胡冉");
        final PrintStream out = System.out;
        Consumer<String> con2=out::println;
        con2.accept("胡冉");
    }

    public void test2(){
        Supplier<String> supplier=String::new;
        final String s = supplier.get();
       System. out.println(s.hashCode());
    }
}