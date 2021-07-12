package ru.stqa.pft.sandbox;

public class Point {
    double x, y;

    public Point(double x1, double y1) {
        this.x = x1;
        this.y = y1;
    }

    public static void main(String[] args) {
        Point p1 = new Point( 5, 2 );
        Point p2 = new Point( 1, 4 );
        System.out.println( "Расстояние между точками P1(" + p1.x + ";" + p1.y + ") и P2(" + p2.x + ";" + p2.y + ") = " + p2.distance( p1 ) );
    }

    public double distance(Point p2) {

        return Math.sqrt( (p2.x - this.x) * (p2.x - this.x) + (p2.y - this.y) * (p2.y - this.y) );

    }
}