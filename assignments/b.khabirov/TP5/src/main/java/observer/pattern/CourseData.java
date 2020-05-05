package observer.pattern;

import java.util.Vector;

import javax.swing.JOptionPane;

import observer.CourseRecord;

/**
 * Represents a vector of CourseRecords.
 */
public class CourseData extends Observable<CourseData.ObservationType, Vector<CourseRecord>> {
	/**
	 * Available observation types for CourseData.
	 */
	enum ObservationType {
		/**
		 * An observation type that will be triggered when a course record is added.
		 */
		ADDITION,
		/**
		 * An observation type that will be triggered when a course record is changed.
		 */
		CHANGE
	}

	/**
	 * Constructs a CourseData object
	 */
	public CourseData() {
	    this.courseData = new Vector<>();
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
				break;
			}
		}
		if (!alreadyExists) {
            this.courseData.addElement(courseRecord);
            this.notifyObserversForTypes(new ObservationType[] { ObservationType.ADDITION });
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
				this.notifyObserversForTypes(new ObservationType[] { ObservationType.CHANGE });
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
	@Override
	public Vector<CourseRecord> getUpdate() {
		return (Vector<CourseRecord>) courseData.clone();
	}

	private Vector<CourseRecord> courseData;
}