package observer.pattern;

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
		this.newCoursesObserver = new Vector<Observer>();
		this.changesObserver = new Vector<Observer>();
	}

	/**
	 * Modified attach method. We have two different type of subscription
	 * @param o Observer that subscribe for updates
	 * @param subscribeForNew subscription for new courses
	 * @param subscribeForUpdate subscription for updates of courses
	 */
	@Override
	public void attach(Observer o, boolean subscribeForNew, boolean subscribeForUpdate) {
		this.observers.addElement(o);
		if(subscribeForNew) this.newCoursesObserver.add(o);
		if(subscribeForUpdate) this.changesObserver.add(o);
	}

	/**
	 * Add a new CourseRecord object
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
			//Set that the course has added
			this.isNewCourseAdded = true;
			//Set that the course info has changed
			this.isCourseInfoChanged = true;
			this.notifyObservers(courseRecord);
		}

	}

	/**
	 * Update an existing CourseRecord object
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
				i = courseData.size();
				//Set that the course info has changed
				this.isCourseInfoChanged = true;
				this.notifyObservers(record);
			}
		}
	}

	/**
	 * Push model of Observer Pattern.
	 * We push only changed courseRecords
	 * @param args courses that has changed/added
	 */
	@Override
	public void notifyObservers(Object args) {
		// update observers subscribed for new courses
		if(isNewCourseAdded){
			for(int i = 0; i < newCoursesObserver.size(); i++){
				Observer observer = newCoursesObserver.elementAt(i);
				observer.update(args);
			}
			isNewCourseAdded = false;
		}
		// update observers subscribed for courses info changes
		if(isCourseInfoChanged){
			for(int i = 0; i < changesObserver.size(); i++){
				Observer observer = changesObserver.elementAt(i);
				observer.update(args);
			}
			isCourseInfoChanged = false;
		}
	}

	/**
	 * Return a copy of the vector of course data. Used by Observers to pull
	 * data.
	 * @return vector of course data
	 */
	public Vector<CourseRecord> getUpdate() {
		return (Vector<CourseRecord>) courseData.clone();
	}

	private Vector<CourseRecord> courseData;

	// Subscription Types
	protected Vector<Observer> newCoursesObserver;
	protected Vector<Observer> changesObserver;

	// State booleans
	private boolean isNewCourseAdded = false;
	private boolean isCourseInfoChanged = false;
}