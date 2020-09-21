package java8.demo01;

/**
 * @program: java8-api
 * @description:
 * @author: HuRan
 * @create: 2020-09-08 18:12
 */
public class Apple {
    private String name;
    private int weight;

    public Apple(Integer weight) {
        this.weight=weight;
    }

    public String getName() {
        return name;
    }
    public Apple(){}
    public Apple(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Apple(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}