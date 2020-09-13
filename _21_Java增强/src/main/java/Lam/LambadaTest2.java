package Lam;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-12 22:45
 */
public class LambadaTest2 {
    @Test
    public void test() {
        happtTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println(aDouble);
            }
        });
        happtTime(500, mo -> {
            System.out.println(mo);
        });
    }

    public void happtTime(double money, Consumer<Double> con) {
        con.accept(money);
    }


    public List<String> filterString(List<String> list, Predicate<String> predicate) {
        List<String> re = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                re.add(s);
            }
        }
        return re;
    }

}