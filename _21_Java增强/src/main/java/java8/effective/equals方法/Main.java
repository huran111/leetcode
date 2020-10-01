package java8.effective.equals方法;

/**
 * @program: java_suanfa
 * @description:
 * @author: HuRan
 * @create: 2020-09-22 17:26
 */
public class Main {
    public static void main(String[] args) {
        Point p = new Point(1, 2);
        ColorPoing colorPoing = new ColorPoing(1, 2, Color.RED);
        SmellPoing smellPoing = new SmellPoing(1, 2, Color.RED);
        System.out.println(smellPoing.equals(colorPoing));


    }
}