package observer.pattern;

import java.util.ArrayList;
import observer.CourseRecord;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author David Prudek
 */
public class ObserverTest {
    
    private ArrayList<Object> objects = new ArrayList<>();
    private Observer observer;
    private CourseData courseData;
    private CourseRecord record;
    
    public ObserverTest() {
    }
    
    @Before
    public void init() {
        observer = new Observer() {
            @Override
            public void update(Observable o) { }

            @Override
            public void update(Object obj) {
                objects.add(obj);
            }
        };
        
        courseData = new CourseData();
        record = new CourseRecord("DesignPatterns", 75);
    }
    
    @Test
    public void addCourseTest() {
        courseData.attach(observer, true, false);
        courseData.addCourseRecord(record);
        
        Assert.assertEquals(record, (CourseRecord) objects.get(0));
    }
    
    @Test
    public void addMoreCourseTest(){
        courseData.attach(observer, true, false);
        courseData.addCourseRecord(record); 
        courseData.addCourseRecord(new CourseRecord("Security", 50));

        Assert.assertEquals(2, objects.size());
    }

    @Test
    public void addCourseFalseAddTest(){
        courseData.attach(observer, false, false);
        courseData.addCourseRecord(record);
        courseData.changeCourseRecord("DesignPatterns", 10);
        
        Assert.assertEquals(0, objects.size());
    }

    @Test
    public void updateCourseTest(){
        courseData.attach(observer, false, true);
        courseData.addCourseRecord(record);
        courseData.changeCourseRecord("DesignPatterns", 50);
        
        Assert.assertEquals(2, objects.size());
        Assert.assertEquals(record, objects.get(0));
        Assert.assertEquals(record, objects.get(1));
    }

    @Test
    public void updateCourseFalseUpdateTest(){
        
        courseData.attach(observer, true, false);
        courseData.addCourseRecord(record);
        courseData.changeCourseRecord("DesignPatterns", 50);
        
        Assert.assertEquals(record, objects.get(0));
    }

    
}
