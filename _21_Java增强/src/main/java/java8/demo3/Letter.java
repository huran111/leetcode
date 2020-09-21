package java8.demo3;

import java.util.function.Function;

/**
 * @program: java_suanfa
 * @description:
 * @author: HuRan
 * @create: 2020-09-11 16:23
 */
public class Letter {
    public static String addHeader(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }

    public static String addFooter(String text) {
        return text + " Kind regards";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }

    public static void main(String[] args) {
        Function<String,String> addHeader=Letter::addHeader;
        final String str = addHeader.andThen(Letter::checkSpelling).andThen(Letter::addFooter).apply("胡冉");
        System.out.println(str);
    }
}