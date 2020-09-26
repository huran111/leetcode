package protptype;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-26 10:24
 */
public class ChildClass implements Cloneable{
    public String name;
    public int age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //浅拷贝
        return super.clone();
    }
}