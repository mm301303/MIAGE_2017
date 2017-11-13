import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Vecteur2DTest {
    private Vecteur2D v1, v2;

    @Before
    public void init(){
        v1 = new Vecteur2D(1,2);
        v2 = new Vecteur2D(-1,-2);
    }

    @Test
    public void multiply() throws Exception {
        Vecteur2D v3 = v1.multiply(2);
        assertEquals(2, v3.getX());
    }

    @Test
    public void add() throws Exception {
    }

    @Test
    public void scalarProduct() throws Exception {
    }

    @Test
    public void transpose() throws Exception {
    }

}