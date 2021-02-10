import java.util.Objects;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2021-01-02 19:35
 */
public class Student {
    public Student(String name, Integer age) {
        this.age = age;
        this.name = name;
    }

    private String name;
    private Integer age;

    public Student(int i, String name) {
        this.age=i;
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(age, student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}