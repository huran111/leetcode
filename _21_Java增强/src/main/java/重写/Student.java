package 重写;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-02 23:38
 */
public class Student extends Person {
    public int no;

    public Student() {
        this(0);
    }

    //默认回去调用父类无参数的构造方法
    //1 父类没有则报错
    //解决 1.父类加一个无参数构造函数 2.显示去调用父类有参数构造函数
    public Student(int no) {
        super(no);
        this.no = no;
    }

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.age);
    }
}