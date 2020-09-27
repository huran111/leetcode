package java8.effective.equals方法;

/**
 * @program: java_suanfa
 * @description:
 * @author: HuRan
 * @create: 2020-09-22 17:17
 */
public class ColorPoing extends Point {
    private final Color color;

    public ColorPoing(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof ColorPoing)) {
//            return false;
//        }
//        return super.equals(o) && ((ColorPoing) o).color == color;
//    }
    //version2

    //    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof Point)) {
//            return false;
//        }
//        if (!(o instanceof ColorPoing)) {
//            return o.equals(o);
//        }
//        return super.equals(o) &&  ((ColorPoing) o).color == color;
//    }
    //version3
    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }
}