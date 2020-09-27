package java8.effective.equals方法;

/**
 * @program: java_suanfa
 * @description:
 * @author: HuRan
 * @create: 2020-09-22 17:17
 */
public class SmellPoing extends Point {
    private final Color color;

    public SmellPoing(int x, int y, Color color) {
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
//        if (!(o instanceof SmellPoing)) {
//            return o.equals(o);
//        }
//        return super.equals(o) &&  ((SmellPoing) o).color == color;
//    }
    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }
}