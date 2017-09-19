import static org.junit.Assert.*;

public class RectangleTest {

    //1 par 1 ça marche, le static nique tout si on lance tous les tests vu qu'il y a rien qui réutilise les instances dans le constructeur (et que max_number=2)

    @org.junit.Test
    public void getS() throws Exception {
        //from static with love
        Rectangle R1=new Rectangle(2.,3.);
        Rectangle R2=new Rectangle(1.,5.);
        assertEquals(R1.getS(), 6., 0.001);
        assertEquals(R2.getS(), 5., 0.001);
    }

    @org.junit.Test
    public void getl() throws Exception {
        //from static with love
        Rectangle R1=new Rectangle(2.,3.);
        Rectangle R2=new Rectangle(1.,5.);

        assertEquals(R1.getl(), 2., 0.001);
        assertEquals(R2.getl(), 1., 0.001);

    }

    @org.junit.Test
    public void getL() throws Exception {
        //from static with love
        Rectangle R1=new Rectangle(2.,3.);
        Rectangle R2=new Rectangle(1.,5.);
        assertEquals(R1.getL(), 3., 0.001);
        assertEquals(R2.getL(), 5., 0.001);
    }

    @org.junit.Test
    public void setl() throws Exception {
        //from static with love
        Rectangle R1=new Rectangle(2.,3.);
        Rectangle R2=new Rectangle(1.,5.);
        R1.setl(5.);
        R2.setl(4.);
        assertEquals(R1.getl(), 5., 0.001);
        assertEquals(R2.getl(), 4., 0.001);

        assertEquals(R1.getS(), 15., 0.001);
        assertEquals(R2.getS(), 20., 0.001);
    }

    @org.junit.Test
    public void setL() throws Exception {
        //from static with love
        Rectangle R1=new Rectangle(2.,3.);
        Rectangle R2=new Rectangle(1.,5.);
        R1.setL(8.);
        R2.setL(9.);
        assertEquals(R1.getL(), 8., 0.001);
        assertEquals(R2.getL(), 9., 0.001);
        assertEquals(R1.getS(), 16., 0.001);
        assertEquals(R2.getS(), 9., 0.001);
    }

}