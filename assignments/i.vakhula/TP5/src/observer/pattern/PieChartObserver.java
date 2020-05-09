package observer.pattern;

import observer.CourseRecord;
import observer.LayoutConstants;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;
import java.util.stream.Collectors;

public class PieChartObserver extends JPanel implements Observer {
    private Vector<CourseRecord> courseData;

    /**
     * Creates a BarChartObserver object
     *
     * @param data a CourseData object to observe
     */
    public PieChartObserver(CourseData data) {
        data.attach(this, Action.BOTH);
        this.courseData = data.getUpdate();
        this.setPreferredSize(new Dimension(2 * LayoutConstants.xOffset
                + (LayoutConstants.barSpacing + LayoutConstants.barWidth)
                * this.courseData.size(), LayoutConstants.graphHeight + 2
                * LayoutConstants.yOffset));
        this.setBackground(Color.white);
    }

    /**
     * Paint method
     *
     * @param g a Graphics object on which to paint
     */
    public void paint(Graphics g) {//, Integer[] data) {
        super.paint(g);
        int radius = 100;

        Integer[] data = courseData.stream()
                .map(CourseRecord::getNumOfStudents)
                .toArray(Integer[]::new);

        //first compute the total number of students
        double total = 0.0;
        for (int i = 0; i < data.length; i++) {
            total += data[i];
        }
        //if total == 0 nothing to draw
        if (total != 0) {
            double startAngle = 0.0;
            for (int i = 0; i < data.length; i++) {
                double ratio = (data[i] / total) * 360.0;
                //draw the arc
                g.setColor(LayoutConstants.courseColours[i % LayoutConstants.courseColours.length]);
                g.fillArc(LayoutConstants.xOffset, LayoutConstants.yOffset, 2 * radius, 2 * radius, (int) startAngle, (int) ratio);
                startAngle += ratio;
            }
        }
    }

    /**
     * Informs this observer that the observed CourseData object has changed
     *
     * @param o the observed CourseData object that has changed
     */
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
    public void update(Object o) {
        CourseRecord courseRecord = (CourseRecord) o;

        final boolean[] notFound = {true};
        this.courseData = this.courseData
                .stream()
                .map(record -> {
                    if (record.getName().equals(courseRecord.getName())) {
                        notFound[0] = false;
                        return courseRecord;
                    }

                    return record;
                })
                .collect(Collectors.toCollection(Vector::new));

        if (notFound[0]) {
            this.courseData.add(courseRecord);
        }

        this.setPreferredSize(new Dimension(2 * LayoutConstants.xOffset
                + (LayoutConstants.barSpacing + LayoutConstants.barWidth)
                * this.courseData.size(), LayoutConstants.graphHeight + 2
                * LayoutConstants.yOffset));
        this.revalidate();
        this.repaint();
    }

}
