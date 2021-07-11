package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
    @Test
    public void testdistance(){
        Point p1 = new Point();
        Point p2 = new Point();
        p1.x1 = 1;
        p1.y1 = 2;
        p2.x2 = 8;
        p2.y2 = -5;
        Assert.assertEquals(Point.distance(p1,p2),9.899494936611665  );

    }
}
