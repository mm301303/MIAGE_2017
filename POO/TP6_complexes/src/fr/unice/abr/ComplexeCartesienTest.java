package fr.unice.abr;

import static org.junit.Assert.*;

public class ComplexeCartesienTest {
    private static final double DELTA = 0.000001;
    IComplexe c1, c2;
    @org.junit.Before
    public void setUp() throws Exception {
        c1 = new ComplexeCartesien(2, 4);
        c2 = new ComplexeCartesien(3, 5);
    }

    @org.junit.Test
    public void getModule() throws Exception {
        assertEquals(c1.getModule(), Math.sqrt(20), DELTA);
        assertEquals(c2.getModule(), Math.sqrt(34), DELTA);

    }

    @org.junit.Test
    public void getArgument() throws Exception {
        assertEquals(c1.getArgument(), Math.acos(2/Math.sqrt(16+4)), DELTA);
        assertEquals(c2.getArgument(), Math.asin(5/c2.getModule()), DELTA);
    }

    @org.junit.Test
    public void getR() throws Exception {
        assertEquals(c1.getR(), 2, DELTA);
        assertEquals(c2.getR(), 3, DELTA);

    }

    @org.junit.Test
    public void getI() throws Exception {
        assertEquals(c1.getI(), 4, DELTA);
        assertEquals(c2.getI(), 5, DELTA);
    }

}