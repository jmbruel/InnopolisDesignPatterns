package pattern;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import observer.CourseRecord;

/**
 * Represents a view of courses and grandes for those courses. Uses observer pattern.
 */
@SuppressWarnings("serial")
public class CourseController extends JPanel implements ChangeListener, ActionListener, Observer  {
	/**
	 * Constructs CourseController object
	 *
	 * @param courses set of courses with respected marks
	 */
	public CourseController(CourseData courses) {
		this.courseData = courses;
		this.sliders = new Vector<JSlider>();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.white);

		coursePanel = new JPanel();
		coursePanel.setBorder(new TitledBorder("My courses"));
		coursePanel.setLayout(new GridLayout(0, 1));

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		courses.attach(this, Observable.Event.Add);
		Vector<CourseRecord> state = courses.getUpdate();

		for (int i = 0; i < state.size(); i++)
			this.addCourse(state.elementAt(i));

		JScrollPane scrollPane = new JScrollPane(coursePanel,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JButton button = new JButton("Add Course");
		button.addActionListener(this);

		constraints.weightx = 0.5;
		constraints.weighty = 1.0;
		constraints.gridx = 0;
		constraints.gridy = 0;
		this.add(scrollPane, constraints);

		constraints.weightx = 0.5;
		constraints.weighty = 0;
		constraints.gridy = 1;
		this.add(button, constraints);
	}

	/**
	 * Adds a new course
	 *
	 * @param course to be added
	 */
	public void addCourse(CourseRecord course) {
		JSlider slider = new JSlider();
		slider.setBackground(Color.white);
		slider.setName(course.getName());
		slider.setValue(course.getNumOfStudents());
		slider.setMinimum(0);
		slider.setMaximum(100);
		slider.setMajorTickSpacing(25);
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setBorder(new TitledBorder(record.getName()));
		slider.addChangeListener(this);
		coursePanel.add(slider);
		coursePanel.revalidate();
		sliders.addElement(slider);
	}

	/**
	 * Informs that a new course has been added
	 *
	 * @param changed CourseData subject that has changed
	 */
	 public void update(Observable changed) {
		CourseData courses = (CourseData) changed;
		Vector<CourseRecord> newCourses = courses.getUpdate();
		for (int i = sliders.size(); i < newCourses.size(); i++) {
			this.addCourse((CourseRecord) newCourses.elementAt(i));
		}
	}

    @Override
    public void update(Object obj) {
        CourseRecord record = (CourseRecord) obj;
        this.addCourse(record);
    }

    /**
	 * Creating new course.
	 */
	public void actionPerformed(ActionEvent arg0) {
		String input = JOptionPane.showInputDialog("Please enter new course name:");
		if (input != null){
			courseData.addCourseRecord(new CourseRecord(input, 50));
			// leave it up notify/update mechanism to invoke this.addCourse
		}
	}

	/**
	 * Mark for a course has changed.
	 *
	 * @param arg0 the JSlider that has changed
	 */
	public void stateChanged(ChangeEvent arg0) {
		JSlider slider = (JSlider) arg0.getSource();
		courseData.changeCourseRecord(slider.getName(), slider.getValue());
	}

	/**
	 * Sets up an initial set of three courses
	 */
    public static void main(String[] args) {
        CourseData data = new CourseData();
        data.addCourseRecord(new CourseRecord("Math", 50));
        data.addCourseRecord(new CourseRecord("English", 50));
        data.addCourseRecord(new CourseRecord("PE", 50));

        CourseController controller = new CourseController(data);
        BarChartObserver bar = new BarChartObserver(data);
        PieChartObserver pie = new PieChartObserver(data);

        JScrollPane scrollPane = new JScrollPane(bar,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JScrollPane scrollPane2 = new JScrollPane(pie,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        JFrame frame = new JFrame("Observer Design Pattern");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridBagLayout());
        frame.setResizable(true);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.25;
        constraints.weighty = 1.0;
        constraints.gridx = 0;
        constraints.gridy = 0;
        frame.getContentPane().add(controller, constraints);
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridx = 1;
        constraints.gridy = 1;
        frame.getContentPane().add(scrollPane2,constraints);
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridx = 1;
        constraints.gridy = 0;
        frame.getContentPane().add(scrollPane, constraints);
        frame.pack();
        frame.setVisible(true);
    }

	private CourseData courseData;

	private Vector<JSlider> sliders;

	private JPanel coursePanel;
}