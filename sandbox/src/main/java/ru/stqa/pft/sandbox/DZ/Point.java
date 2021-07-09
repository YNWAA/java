package ru.stqa.pft.sandbox.DZ;

public class Point {

    public static void main (String[] args) {
        PointClass p1= new PointClass(5,-7,1,9);
        System.out.println("Расстояния между двумя точками P1(" + p1.x1 + ";" + p1.y1 + ") и P2(" + p1.x2 + ";" + p1.y2 + ") =" + p1.distance());
    }
}