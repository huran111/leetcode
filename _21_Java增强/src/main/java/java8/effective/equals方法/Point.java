package java8.effective.equals方法;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: java_suanfa
 * @description:
 * @author: HuRan
 * @create: 2020-09-22 17:15
 */
public class Point {

    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }
}