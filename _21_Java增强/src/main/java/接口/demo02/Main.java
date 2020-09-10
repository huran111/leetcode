package 接口.demo02;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-05 22:05
 */
public class Main {
    public static void main(String[] args) {
        Dog.run();
        Animal.run();
        Dog dog=new Dog();
        dog.run();
      Animal animal=new Animal();
      animal.run();
      Animal animal1=new Dog();
        animal1.run2();//多态只是针对于 实例方法 静态方法不行
        Dog dog1= (Dog) new Animal();//报错 Animal不是Dog的实例对象

    }
}