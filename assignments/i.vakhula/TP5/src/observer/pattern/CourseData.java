package observer.pattern;

import observer.CourseRecord;

import javax.swing.*;
import java.util.Vector;

/**
 * Represents a vector of CourseRecords.
 */
public class CourseData extends Observable {

    private Vector<CourseRecord> courseData;
    private Vector<Observer> addObservers;
    private Vector<Observer> changeObservers;


    /**
     * Constructs a CourseData object
     */
    public CourseData() {
        this.courseData = new Vector<>();
        this.addObservers = new Vector<>();
        this.changeObservers = new Vector<>();
    }

    @Override
    public void attach(Observer o, Action action) {
        if (action == Action.ADD) {
            addObservers.add(o);
        } else if (action == Action.CHANGE) {
            changeObservers.add(o);
        } else {
            addObservers.add(o);
            changeObservers.add(o);
        }
    }

    /**
     * Add a new CourseRecord object
     *
     * @param courseRecord the CourseRecord to be added
     */
    public void addCourseRecord(CourseRecord courseRecord) {
        boolean alreadyExists = false;
        for (int i = 0; i < courseData.size(); i++) {
            CourseRecord record = courseData.elementAt(i);
            if (record.getName().equals(courseRecord.getName())) {
                alreadyExists = true;
                JOptionPane
                        .showMessageDialog(
                                null,
                                "Warning: Attempt to add new course with an already existing name",
                                "alert", JOptionPane.ERROR_MESSAGE);
                i = courseData.size(); // exit the loop
            }
        }
        if (!alreadyExists) {
            this.courseData.addElement(courseRecord);
            this.notifyGroupObservers(courseRecord, this.addObservers);
        }
    }


    /**
     * Update an existing CourseRecord object
     *
     * @param subjectName   the name CourseRecord to be updated
     * @param numOfStudents the new number of students for this course
     */
    public void changeCourseRecord(String subjectName, int numOfStudents) {
        CourseRecord courseRecord = this.courseData
                .stream()
                .filter(record -> record.getName().equals(subjectName))
                .findFirst().orElseThrow();

        courseRecord.setNumOfStudents(numOfStudents);

        this.notifyGroupObservers(courseRecord, this.changeObservers);
    }

    /**
     * Return a copy of the vector of course data. Used by Observers to pull
     * data.
     *
     * @return vector of course data
     */
    public Vector<CourseRecord> getUpdate() {
        return (Vector<CourseRecord>) courseData.clone();
    }

    private void notifyGroupObservers(CourseRecord courseRecord, Vector<Observer> observers) {
        observers.forEach(observer -> observer.update(courseRecord));
    }

}