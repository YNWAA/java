package ru.stqa.pft.sandbox;

public class EquationTest {
    @org.testng.annotations.Test
    public void test0() {
        Equation e = new ru.stqa.pft.sandbox.Equation( 1, 1, 1 );
        org.testng.Assert.assertEquals( e.rootNumber(), 0 );
    }

    @org.testng.annotations.Test
    public void test1() {
        Equation e = new ru.stqa.pft.sandbox.Equation( 1, 2, 1 );
        org.testng.Assert.assertEquals( e.rootNumber(), 1 );
    }

    @org.testng.annotations.Test
    public void test2() {
        Equation e = new ru.stqa.pft.sandbox.Equation( 1, 6, 2 );
        org.testng.Assert.assertEquals( e.rootNumber(), 2 );
    }
    @org.testng.annotations.Test
    public void testLinear() {
        Equation e = new ru.stqa.pft.sandbox.Equation( 0, 1, 1 );
        org.testng.Assert.assertEquals( e.rootNumber(), 1 );
    }
    @org.testng.annotations.Test
    public void testConst() {
        Equation e = new ru.stqa.pft.sandbox.Equation( 0, 0, 1 );
        org.testng.Assert.assertEquals( e.rootNumber(), 0 );
    }
    @org.testng.annotations.Test
    public void testZero() {
        Equation e = new ru.stqa.pft.sandbox.Equation( 0, 0, 0 );
        org.testng.Assert.assertEquals( e.rootNumber(), -1 );
    }
}
