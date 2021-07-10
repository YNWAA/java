package ru.stqa.pft.sandbox.DZ;

public class Point {

    double x1, y1, x2, y2;

    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point();
        p1.x1 = 1;
        p1.y1 = 5;
        p2.x2 = 8;
        p2.y2 = 4;
        System.out.println( "Расстояние между точками P1(" + p1.x1 + ";" + p1.y1 + ") и (" + p2.x2 + ";" + p2.y2 + ") = " + distance( p1, p2 ) );
    }

    public static double distance(Point p1, Point p2) {

        return Math.sqrt( (p2.x2 - p1.x1) * (p2.x2 - p1.x1) + (p2.y2 - p1.y1) * (p2.y2 - p1.y1) );

    }
}