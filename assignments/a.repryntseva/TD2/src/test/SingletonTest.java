package test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import game.Reine;
import game.Roi;

public class SingletonTest {
    @Test
    public void TestRoi() {
        Roi roi1 = Roi.getRoi();
        Roi roi2 = Roi.getRoi();
        assertEquals(roi1, roi2);
    }

    @Test
    public void TestReine() {
        Reine reine1 = Reine.getReine();
        Reine reine2 = Reine.getReine();
        assertEquals(reine1, reine2);
    }

}
