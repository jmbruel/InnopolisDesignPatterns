package observer.pattern;

import observer.CourseRecord;
import observer.LayoutConstants;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class PieChartObserver extends JPanel implements Observer {
    private Vector<CourseRecord> courseData;

    public PieChartObserver(CourseData data) {
        data.attach(this, false, true);
        this.courseData = data.getUpdate();
        this.setBackground(Color.white);
    }

    /**
     * Paint method
     * @param g a Graphics object on which to paint
     */
    public void paint(Graphics g) {
        super.paint(g);
        int radius = 100;

        //first compute the total number of students
        double total = 0.0;
        for (int i = 0; i < courseData.size(); i++) {
            total += courseData.elementAt(i).getNumOfStudents();
        }
        //if total == 0 nothing to draw
        if (total != 0) {
            double startAngle = 0.0;
            for (int i = 0; i < courseData.size(); i++) {
                double ratio = (courseData.elementAt(i).getNumOfStudents() / total) * 360.0;
                //draw the arc
                g.setColor(LayoutConstants.courseColours[i%LayoutConstants.courseColours.length]);
                g.fillArc(LayoutConstants.xOffset, LayoutConstants.yOffset , 2 * radius, 2 * radius,
                        (int) startAngle, (int) ratio);
                startAngle += ratio;
            }
        }
    }

    /**
     * Informs this observer that the observed CourseData object has changed
     * @param o the observed CourseData object that has changed
     */
    public void update(Observable o) {
        CourseData data = (CourseData) o;
        this.courseData = data.getUpdate();
        this.revalidate();
        this.repaint();
    }

    @Override
    public void update(Object args) {
        CourseRecord record = (CourseRecord) args;
        boolean found = false;
        for(int i = 0; i < courseData.size(); i++){
            if(courseData.get(i).getName().equals(record.getName())) {
                courseData.set(i, record);
                found = true;
            }
        }

        if(!found) courseData.add(record);
        this.revalidate();
        this.repaint();
    }
}