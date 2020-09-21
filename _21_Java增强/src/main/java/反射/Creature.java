package 反射;

import java.io.Serializable;

/**
 * @program: java_suanfa
 * @description:
 * @author: HuRan
 * @create: 2020-09-11 14:15
 */
public class Creature<T>implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("呼吸");
    }
    public void eat(){
        System.out.println("生物吃东西");
    }
}