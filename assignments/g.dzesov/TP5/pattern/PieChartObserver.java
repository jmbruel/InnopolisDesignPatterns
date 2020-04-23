package pattern;

import observer.CourseRecord;
import observer.LayoutConstants;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;


@SuppressWarnings("serial")
public class PieChartObserver extends JPanel implements Observer {
	public PieChartObserver(CourseData data) {
		data.attach(this, Observable.Event.All);
		this.courseData = data.getUpdate();
		this.setPreferredSize(new Dimension(2 * LayoutConstants.xOffset
				+ (LayoutConstants.barSpacing + LayoutConstants.barWidth)
				* this.courseData.size(), LayoutConstants.graphHeight + 2
				* LayoutConstants.yOffset));
		this.setBackground(Color.white);
	}

	public void paint(Graphics g) {
		super.paint(g);

        int radius = 100;

        double total = 0.0;
        for (int i = 0; i < courseData.size(); i++) {
            total += courseData.elementAt(i).getNumOfStudents();
        }

        if (total != 0) {
            double startAngle = 0.0;
            for (int i = 0; i <  courseData.size(); i++) {
                double ratio = (courseData.elementAt(i).getNumOfStudents() / total) * 360.0;
                //draw the arc
                g.setColor(LayoutConstants.courseColours[i%LayoutConstants.courseColours.length]);
                g.fillArc(LayoutConstants.xOffset, LayoutConstants.yOffset, 2 * radius, 2 * radius, (int) startAngle, (int) ratio);
                startAngle += ratio;
            }
        }
	}

	public void update(Observable o) {
		CourseData data = (CourseData) o;
		this.courseData = data.getUpdate();

		this.setPreferredSize(new Dimension(2 * LayoutConstants.xOffset
				+ (LayoutConstants.barSpacing + LayoutConstants.barWidth)
				* this.courseData.size(), LayoutConstants.graphHeight + 2
				* LayoutConstants.yOffset));
		this.revalidate();
		this.repaint();
	}

    @Override
    public void update(Object obj) {
        CourseRecord record = (CourseRecord) obj;
        boolean changed = false;
        for (int i = 0; i < this.courseData.size(); i++) {
            if (record.getName().equals(this.courseData.get(i).getName())) {
                changed = true;
                this.courseData.set(i, record);
            }
        }

        if (!changed)
            this.courseData.add(record);

        this.setPreferredSize(new Dimension(2 * LayoutConstants.xOffset
                + (LayoutConstants.barSpacing + LayoutConstants.barWidth)
                * this.courseData.size(), LayoutConstants.graphHeight + 2
                * LayoutConstants.yOffset));
        this.revalidate();
        this.repaint();
    }

    private Vector<CourseRecord> courseData;
}