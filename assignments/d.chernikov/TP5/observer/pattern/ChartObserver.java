package observer.pattern;

import observer.CourseRecord;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public abstract class ChartObserver extends JPanel implements PushObserver<Vector<CourseRecord>> {
    /**
     * Initialize a ChartObserver super object
     *
     * @param data
     *            a CourseData object to observe
     */
    ChartObserver(CourseData data) {
        data.attach(this);
        this.courseData = data.getUpdate();
        this.setPreferredSize(getChartPreferredSize());
        this.setBackground(Color.white);
    }

    /**
     * Informs this observer that the observed CourseData object has changed
     *
     * @param data
     *            the data of the observed CourseData object that has changed
     */
    @Override
    public void update(Vector<CourseRecord> data) {
        this.courseData = data;

        this.setPreferredSize(getChartPreferredSize());
        this.revalidate();
        this.repaint();
    }

    protected abstract Dimension getChartPreferredSize();

    protected Vector<CourseRecord> courseData;
}
