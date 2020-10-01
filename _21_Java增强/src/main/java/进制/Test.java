package 进制;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: java_suanfa
 * @description:
 * @author: HuRan
 * @create: 2020-09-23 13:01
 */
public class Test {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String s1 : list) {
            if("2".equals(s1)){
                list.remove(s1);
            }
        }
        System.out.println(list.size());
    }
}