package 注解;

import java.util.ArrayList;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-10 22:26
 */
@MaAnnation(value = "hello")
@MaAnnation(value = "hr")
public class Generic<@MaAnnation T> {

    public void show() throws @MaAnnation RuntimeException {
        ArrayList<@MaAnnation String> list = new ArrayList<>();
        int num = (@MaAnnation int) 10L;
    }

}