package observer.pattern;

import observer.CourseRecord;
import observer.LayoutConstants;

import java.awt.*;

/**
 * This class represents a pie chart view of a vector of data. Uses the Observer
 * pattern.
 */
@SuppressWarnings("serial")
public class PieChartObserver extends ChartObserver {
    /**
     * Creates a PieChartObserver object
     *
     * @param data a CourseData object to observe
     */
    public PieChartObserver(CourseData data) {
        super(data);
    }

    @Override
    protected Dimension getChartPreferredSize() {
        return new Dimension(
                2 * LayoutConstants.pieChartRadius + 2 * LayoutConstants.xOffset,
                2 * LayoutConstants.pieChartRadius + 2 * LayoutConstants.yOffset);
    }

    /**
     * Paint method
     *
     * @param g a Graphics object on which to paint
     */
    public void paint(Graphics g) {
        super.paint(g);
        double total = 0.0;
        for (int i = 0; i < courseData.size(); i++) {
            total += courseData.elementAt(i).getNumOfStudents();
        }
        if (total != 0) {
            double startAngle = 0.0;
            for (int i = 0; i < courseData.size(); i++) {
                CourseRecord record = courseData.elementAt(i);
                double ratio = (record.getNumOfStudents() / total) * 360.0;
                //draw the arc
                g.setColor(LayoutConstants.courseColours[i % LayoutConstants.courseColours.length]);
                g.fillArc(
                        LayoutConstants.xOffset,
                        LayoutConstants.yOffset,
                        2 * LayoutConstants.pieChartRadius,
                        2 * LayoutConstants.pieChartRadius,
                        (int) startAngle, (int) ratio);
                startAngle += ratio;
            }
        }
    }
}
