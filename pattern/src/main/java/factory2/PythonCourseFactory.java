package factory2;

import factory.ICourse;
import factory.PythonCourse;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-24 21:49
 */
public class PythonCourseFactory implements ICourseFactory {
    public ICourse create() {
        return new PythonCourse();
    }
}