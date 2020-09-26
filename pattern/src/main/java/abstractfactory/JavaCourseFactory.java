package abstractfactory;

import factory.ICourse;
import factory.JavaCourse;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-24 22:07
 */
public class JavaCourseFactory implements ICourseFactory {
    public ICourse createCourse() {
        return new JavaCourse();
    }

    public INote createNote() {
        return new JavaNote();
    }

    public IVideo createVideo() {
        return new JavaVideo();
    }
}