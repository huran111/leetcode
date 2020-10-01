package java8.demo3;

/**
 * @program: java_suanfa
 * @description:
 * @author: HuRan
 * @create: 2020-09-11 16:48
 */
public class Dish {
    private String name;
    private boolean vegetarian;
    private int calories;
    private Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }
    public String getName() {         return name;     }

    public boolean isVegetarian() {         return vegetarian;     }

    public int getCalories() {         return calories;     }

    public Type getType() {         return type;     }

    @Override     public String toString() {         return name;     }
    public enum Type { MEAT, FISH, OTHER}

    }