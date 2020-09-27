package protptype;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-26 10:24
 */
public class FatherClass implements Cloneable {
    public String name;
    public int age;
    ChildClass childClass;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //浅拷贝
        final FatherClass f = (FatherClass) super.clone();
        f.childClass = (ChildClass) this.childClass.clone();
        return f;
    }
}