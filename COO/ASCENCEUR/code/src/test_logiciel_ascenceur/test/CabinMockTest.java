package test_logiciel_ascenceur.test;

import logiciel_ascenseur.mock.cabin.CabinMock;
import logiciel_ascenseur.mock.cabin.CabinState;
import logiciel_ascenseur.mock.cabin.EngineMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CabinMockTest {

    CabinMock c;

    @Before
    public void resetCabin(){
        c= new CabinMock(0, 0, new EngineMock());
    }

    @Test
    public void getState() {
        Assert.assertEquals(CabinState.ARRET_OUVERT, c.getState());//begins with open doors
        assertEquals(0, c.getStage());//begins with open doors

        int newStageNumber = 1;
        c.setSelection(newStageNumber);
        c.notifyNewStage(newStageNumber);
        assertEquals(CabinState.ARRET_OUVERT, c.getState());//begins with open doors


        newStageNumber = 15;
        c.setSelection(newStageNumber);
        for(int i = 0; i<=15; i++) {
            c.notifyNewStage(i);
            if(i!=15){
                assertEquals(CabinState.EN_MONTEE, c.getState());//stays with closed doors
            }else{
                assertEquals(CabinState.ARRET_OUVERT, c.getState());//ends with open doors
            }
        }
    }

    @Test
    public void getStage(){//test for ascend
        int newStageNumber = 1;
        c.setSelection(newStageNumber);
        c.notifyNewStage(1);
        assertEquals(1, c.getStage());//stays with closed doors


        newStageNumber = 15;
        c.setSelection(newStageNumber);
        for(int i = 0; i<=15; i++) {
            c.notifyNewStage(i);
            assertEquals(i, c.getStage());//stays with closed doors

        }
    }

    @Test
    public void setDescendingState() throws Exception {
        c.setStage(15);

        int newStageNumber = 0;
        c.setSelection(newStageNumber);
        for(int i = 15; i<=newStageNumber; i--) {
            c.notifyNewStage(i);
            if(i!=15){
                assertEquals(CabinState.EN_DESCENTE, c.getState());//stays with closed doors
            }else{
                assertEquals(CabinState.ARRET_OUVERT, c.getState());//ends with open doors
            }
        }
    }

    @Test
    public void setRisingState() throws Exception {

        int newStageNumber = 15;
        c.setSelection(newStageNumber);
        for(int i = 0; i<=15; i++) {
            c.notifyNewStage(i);
            if(i!=15){
                assertEquals(CabinState.EN_MONTEE, c.getState());//stays with closed doors
            }
        }
    }

    @Test
    public void setStoppedState() throws Exception {

        int newStageNumber = 15;
        c.setSelection(newStageNumber);
        for(int i = 0; i<=15; i++) {
            c.notifyNewStage(i);
            if(i==newStageNumber)
                assertEquals(CabinState.ARRET_OUVERT, c.getState());//stays with closed doors

        }
    }

}