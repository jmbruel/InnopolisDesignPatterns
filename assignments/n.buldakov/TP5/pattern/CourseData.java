package pattern;

import java.util.Vector;

import javax.swing.JOptionPane;

import observer.CourseRecord;

/**
 * Represents a vector of CourseRecords.
 */
public class CourseData extends Observable {

	/**
	 * Constructs a CourseData object
	 */
	public CourseData() {

	    this.courseData = new Vector<CourseRecord>();
        this.observersForChange = new Vector<>();
        this.observersForAdd = new Vector<>();
	}

	/**
	 * Add a new observer.CourseRecord object
	 * 
	 * @param courseRecord
	 *            the observer.CourseRecord to be added
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
            this.notifyObserversRecordAdded(courseRecord);
        }
	}

    public void notifyObserversRecordAdded(CourseRecord record) {
        for (int i = 0; i < observersForAdd.size(); i++) {
            Observer observer = observersForAdd.elementAt(i);
            observer.update(record);
        }
    }

    public void notifyObserversRecordChanged(CourseRecord record) {
        for (int i = 0; i < observersForChange.size(); i++) {
            Observer observer = observersForChange.elementAt(i);
            observer.update(record);
        }
    }

    /**
	 * Update an existing observer.CourseRecord object
	 * 
	 * @param subjectName
	 *            the name observer.CourseRecord to be updated
	 * @param numOfStudents
	 *            the new number of students for this course
	 */
	public void changeCourseRecord(String subjectName, int numOfStudents) {
		for (int i = 0; i < courseData.size(); i++) {
			CourseRecord record = courseData.elementAt(i);
			if (record.getName().equals(subjectName)) {
				record.setNumOfStudents(numOfStudents);
                this.notifyObserversRecordChanged(record);
                break;
			}
		}
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

    @Override
    public void attach(Observer o, Event forEvent) {
        if (forEvent == Event.Add || forEvent == Event.All)
            observersForAdd.add(o);
        if (forEvent == Event.Change || forEvent == Event.All)
            observersForChange.add(o);
    }

    private Vector<CourseRecord> courseData;

    protected Vector<Observer> observersForChange;
    protected Vector<Observer> observersForAdd;
}