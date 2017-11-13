import static org.junit.Assert.*;

public class VecteurTest {
    private Vecteur v1, v2, v3;

    @org.junit.Before
    public void setUp(){
        v1 = new Vecteur(1,2,3,4,5,6,7,8,9,10);
        v2 = new Vecteur(10,9,8,7,6,5,4,3,2,1);
        v3 = new Vecteur(1, 2);
    }

    @org.junit.Test
    public void recherche(){
        assertEquals(2, v1.recherche(3));
        assertEquals(7, v2.recherche(3));
        assertEquals(1, v3.recherche(2));
    }

    @org.junit.Test
    public void rechercheDichotomique(){
        assertEquals(2, v1.rechercheDichotomique(3));

        assertEquals(1, v3.rechercheDichotomique(2));
    }

}