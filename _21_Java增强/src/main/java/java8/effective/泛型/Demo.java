package java8.effective.泛型;

import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-01-24 11:47
 */
public class Demo {
    /**
     * 看上去没什么危险，实际上很危险 这个数组的类型，是由传到方法的参数的编译时类型来决定的
     * 编译器没有足够的信息去做精确的判断，它会将堆污染传到调用栈上
     *
     * @param args
     * @param <T>
     * @return 返回的是其可变参数数组
     */
    static <T> T[] toArray(T... args) {
        return args;
    }

    /**
     * 这个方法本身没有什么危险，也不会产生警告，
     * 但是除非它调用了带有泛型可变参数的toArray()方法
     *
     * @param a
     * @param b
     * @param c
     * @param <T>
     * @return
     */
    static <T> T[] pickTow(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:
                return toArray(a, b);
            case 1:
                return toArray(a, c);
            case 2:
                return toArray(b, c);
        }
        return null;
    }

    /**
     * 方法中 带有一个任意数量参数的列表，并按照顺序返回包含输入清单中所有元素的唯一列表
     *
     * @param lists
     * @param <T>
     * @return
     */
    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>... lists) {

        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {

            result.addAll(list);
        }
        return result;
    }

    public static void main(String[] args) {

        //才运行的时候抛出ClassCastException
        //因为编译器在返回值上产生了一个隐藏的String[]转换，但是转换失败了，
        String[] attributes = pickTow("Good", "Fast", "Cheap");

    }

}