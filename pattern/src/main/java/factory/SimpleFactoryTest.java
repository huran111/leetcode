package factory;

import factory2.ICourseFactory;
import factory2.PythonCourseFactory;

import java.util.concurrent.CountDownLatch;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-24 18:53
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
        ICourse course=new JavaCourse();
        course.record();
        CourseFactory factory=new CourseFactory();
        final ICourse course1 = factory.create(JavaCourse.class);
        course1.record();

        final ICourseFactory pythonCourseFactory = new PythonCourseFactory();
        final ICourse iCourse = pythonCourseFactory.create();
        iCourse.record();
    }
}