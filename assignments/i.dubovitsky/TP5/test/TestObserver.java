package test;

import observer.CourseRecord;
import observer.pattern.CourseData;
import observer.pattern.Observable;
import observer.pattern.Observer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestObserver {
    private ArrayList<Object>  objects = new ArrayList<>();
    private Observer observer;
    private CourseData courseData;
    private CourseRecord record;

    @BeforeEach
    public void init(){
        observer = new Observer() {
            @Override
            public void update(Observable o) { }

            @Override
            public void update(Object args) {
                objects.add(args);
            }
        };

        courseData = new CourseData();
        record = new CourseRecord("Test", 50);
    }

    @Test
    public void testObserverForAdd(){
        courseData.attach(observer, true, false);
        courseData.addCourseRecord(record);
        courseData.changeCourseRecord("Test", 55);

        Assertions.assertEquals(1, objects.size());
        Assertions.assertEquals(record, objects.get(0));
    }

    @Test
    public void testObserverForNothing(){
        courseData.attach(observer, false, false);
        courseData.changeCourseRecord("Test", 55);

        Assertions.assertEquals(0, objects.size());
    }

    @Test
    public void testObserverForChange(){
        courseData.attach(observer, false, true);
        courseData.addCourseRecord(record);
        courseData.changeCourseRecord("Test", 55);

        Assertions.assertEquals(1, objects.size());
        Assertions.assertEquals(record, objects.get(0));
    }

    @Test
    public void testObserverForBoth(){
        courseData.attach(observer, true, true);
        courseData.addCourseRecord(record);
        courseData.changeCourseRecord("Test", 55);

        Assertions.assertEquals(2, objects.size());
        Assertions.assertEquals(record, objects.get(0));
        Assertions.assertEquals(record, objects.get(1));
    }

}