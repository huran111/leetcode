package protptype;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-26 10:25
 */
public class Main {
    public static void main(String[] args) {
        FatherClass fatherClass=new FatherClass();
        fatherClass.name="huran";
        fatherClass.age=12;
        fatherClass.childClass=new ChildClass();
        fatherClass.childClass.name="a";
        fatherClass.childClass.age=222;

        try {
            final FatherClass fatherClassB = (FatherClass) fatherClass.clone();
            System.out.println(fatherClass.hashCode());
            System.out.println(fatherClassB.hashCode());
            System.out.println(fatherClass.name);
            System.out.println(fatherClassB.age);
            System.out.println(fatherClass == fatherClassB);
            System.out.println(fatherClass.childClass == fatherClassB.childClass);
            System.out.println(fatherClass.childClass.hashCode());
            System.out.println(fatherClassB.childClass.hashCode());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}