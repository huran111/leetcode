package 重写;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-02 23:26
 */
public class Cat extends Animal {
    @Override
    public void speak() {
        super.speak();
        run();
        super.run();
        System.out.println("Cat Speak");
    }

    @Override
    public void run() {
        System.out.println("Cat Run");
    }

    public static void main(String[] args) {
        Cat cat=new Cat();
        cat.speak();
    }
}