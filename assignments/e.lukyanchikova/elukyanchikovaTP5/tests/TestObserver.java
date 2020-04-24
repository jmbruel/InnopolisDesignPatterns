package elukyanchikovaTP5.tests;

import elukyanchikovaTP5.CourseRecord;
import elukyanchikovaTP5.pattern.CourseData;
import elukyanchikovaTP5.pattern.Observable;
import elukyanchikovaTP5.pattern.Observer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestObserver {
    private ArrayList<Object> objects = new ArrayList<>();
    private Observer observer;
    private CourseData courseData;
    private CourseRecord record;

    @BeforeEach
    public void init() {
        observer = new Observer() {
            @Override
            public void update(Observable o) {
            }

            @Override
            public void update(Object args) {
                objects.add(args);
            }
        };

        courseData = new CourseData();
        record = new CourseRecord("Design Patterns", 30);
    }

    @Test
    public void testRecordAddition() {
        init();
        courseData.attach(observer, true, false);
        courseData.addCourseRecord(record);
        // indicates record can be added
        Assertions.assertEquals(record, (CourseRecord) objects.get(0));
    }

    @Test
    public void testRecordUpdateFalseAdditionTrue() {
        init();
        courseData.attach(observer, true, false);
        courseData.addCourseRecord(record);
        courseData.changeCourseRecord("Design Patterns", 30);
        // indicates that the record is addition is perceived, changes are not perceived)
        Assertions.assertEquals(1, objects.size());
        Assertions.assertEquals(record, objects.get(0));
    }

    @Test
    public void testUpdateFalseAdditionFalse() {
        init();
        courseData.attach(observer, false, false);
        courseData.changeCourseRecord("Design Patterns", 30);
        // indicates no changes or additiobs are perceived by the elukyanchikovaTP5.observer
        Assertions.assertEquals(0, objects.size());
    }


    @Test
    public void testUpdateTrueAdditionTrue() {
        init();
        courseData.attach(observer, true, true);
        courseData.addCourseRecord(record);
        courseData.changeCourseRecord("Design Patterns", 30);
        // indicated that both additions and changes are observed
        Assertions.assertEquals(2, objects.size());
        Assertions.assertEquals(record, objects.get(0));
        Assertions.assertEquals(record, objects.get(1));
    }

}