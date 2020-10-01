package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @program: java8-api
 * @description:
 * @author: HuRan
 * @create: 2020-09-08 09:46
 */
public class Java8ApiTest2 {
    public static List<Emp> list = new ArrayList<>();

    static {
        list.add(new Emp("xiaoHong1", 20, 1000.0));
        list.add(new Emp("xiaoHong2", 25, 2000.0));
        list.add(new Emp("xiaoHong3", 30, 3000.0));
        list.add(new Emp("xiaoHong4", 35, 4000.0));
        list.add(new Emp("xiaoHong5", 38, 5000.0));
        list.add(new Emp("xiaoHong6", 45, 9000.0));
        list.add(new Emp("xiaoHong7", 55, 10000.0));
        list.add(new Emp("xiaoHong8", 42, 15000.0));
    }

    public static void println(Stream<Emp> stream) {
        stream.forEach(emp -> {
            System.out.println(String.format("名字：%s，年纪：%s，薪水：%s", emp.getName(), emp.getAge(), emp.getSalary()));
        });
    }

    public static void main(String[] args) {
        // 对数组流，先过滤重复，在排序，再控制台输出 1，2，3
        Arrays.asList(3,1,2,1).stream().distinct().sorted().forEach(str->{
            System.out.println(str);
        });
        // 对list里的emp对象，取出薪水，并对薪水进行排序，然后输出薪水的内容，map操作，改变了Strenm的泛型对象
        list.stream().map(emp -> emp.getSalary()).sorted().forEach(salary->{
            System.out.println(salary);
        });
        System.out.println(list.stream().sorted(Comparator.comparing(Emp::getName)));

        Stream<Emp> peek = list.stream().filter(emp -> {
            return emp.getAge() > 30;
        }).peek(emp -> {
            emp.setSalary(emp.getSalary() * 1.5);
        });
        System.out.println(peek);
        Stream.iterate(1, x->++x).skip(5).limit(10).forEach(System.out::println);

    }

    public static class Emp {
        private String name;
        private Integer age;
        private Double salary;

        public Emp(String name, Integer age, Double salary) {
            super();
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

    }
}