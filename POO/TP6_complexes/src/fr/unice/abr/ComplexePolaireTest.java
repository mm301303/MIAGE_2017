package fr.unice.abr;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexePolaireTest {
    private static final double DELTA = 0.000001;
    IComplexe c1, c2;
    @org.junit.Before
    public void setUp() throws Exception {
        c1 = new ComplexePolaire(Math.PI/7, 4);
        c2 = new ComplexePolaire(Math.PI/9, 5);
    }


    @Test
    public void getModule() throws Exception {
        assertEquals(c1.getModule(), 4, DELTA);
        assertEquals(c2.getModule(), 5, DELTA);
    }

    @Test
    public void getArgument() throws Exception {
        assertEquals(c1.getArgument(),Math.PI/7, DELTA );
        assertEquals(c2.getArgument(),Math.PI/9, DELTA );
    }

}