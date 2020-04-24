package test;

import observer.CourseRecord;
import observer.pattern.CourseData;
import observer.pattern.Observable;
import observer.pattern.Observer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestCases {
    @Test
    public void testCase1NewCourse(){
        final Object[] obj = new Object[1];
        Observer test1 = new Observer() {
            @Override
            public void update(Observable o) { }

            @Override
            public void update(Object args) {
                 obj[0] = args;
            }
        };

        CourseData courseData = new CourseData();
        courseData.attach(test1, true, false);
        CourseRecord rec = new CourseRecord("Physics", 50);
        courseData.addCourseRecord(rec);

        Assertions.assertNotNull(obj[0]);
        Assertions.assertTrue(obj[0] instanceof CourseRecord);
        Assertions.assertEquals(rec, (CourseRecord)obj[0]);
    }

    @Test
    public void testCase2UpdCourse(){
        final Object[] obj = new Object[1];
        Observer test1 = new Observer() {
            @Override
            public void update(Observable o) { }

            @Override
            public void update(Object args) {
                obj[0] = args;
            }
        };

        CourseData courseData = new CourseData();
        courseData.attach(test1, false, true);
        CourseRecord rec = new CourseRecord("Physics", 50);
        courseData.addCourseRecord(rec);

        courseData.changeCourseRecord("Physics", 100);

        Assertions.assertNotNull(obj[0]);
        Assertions.assertTrue(obj[0] instanceof CourseRecord);
        Assertions.assertEquals(rec, (CourseRecord)obj[0]);
        Assertions.assertEquals(100, ((CourseRecord)obj[0]).getNumOfStudents());
    }
}
