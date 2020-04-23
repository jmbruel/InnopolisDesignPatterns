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
		this.changeObservers = new Vector<>();
		this.newCourseObservers = new Vector<>();
	}

	/**
	 * Add a new CourseRecord object
	 * 
	 * @param courseRecord
	 *            the CourseRecord to be added
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
		if (!alreadyExists)
			this.courseData.addElement(courseRecord);

		for (int i = 0; i < newCourseObservers.size(); i++) {
			Observer observer = newCourseObservers.elementAt(i);
			observer.update(newCourseObservers);
		}
	}

	/**
	 * Update an existing CourseRecord object
	 * 
	 * @param subjectName
	 *            the name CourseRecord to be updated
	 * @param numOfStudents
	 *            the new number of students for this course
	 */
	public void changeCourseRecord(String subjectName, int numOfStudents) {
		for (int i = 0; i < courseData.size(); i++) {
			CourseRecord record = courseData.elementAt(i);
			if (record.getName().equals(subjectName)) {
				record.setNumOfStudents(numOfStudents);

				for (int j = 0; j < changeObservers.size(); j++) {
					Observer observer = changeObservers.elementAt(j);
					observer.update(record);
				}

				break;
			}
		}
		this.notifyObservers();
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

	private Vector<CourseRecord> courseData;
	private Vector<Observer> changeObservers;
	private Vector<Observer> newCourseObservers;
}