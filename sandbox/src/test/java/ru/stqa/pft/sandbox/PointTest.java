package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
    @Test
    public void testdistance(){
        Point p1 = new Point(5,2);
        Point p2 = new Point(1,4);
        Assert.assertEquals(p2.distance(p1),9.899494936611665  );

    }
}
