package test_logiciel_ascenceur.test;

import logiciel_ascenseur.mock.cabin.CabinState;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CabinStateTest {
    @Test
    public void toStringTest(){
        Assert.assertEquals("Arretée, portes fermées", CabinState.ARRET_FERME.toString());
        assertEquals("En montée, portes fermées",CabinState.EN_MONTEE.toString());
        assertEquals("En descente, portes fermées",CabinState.EN_DESCENTE.toString());
        assertEquals("Arretée, portes ouvertes",CabinState.ARRET_OUVERT.toString());
    }

}