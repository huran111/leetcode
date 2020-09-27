package factory2;

import factory.ICourse;
import factory.JavaCourse;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-24 21:48
 */
public class JavaCourseFactory implements ICourseFactory {
    public ICourse create() {
        return new JavaCourse();
    }
}