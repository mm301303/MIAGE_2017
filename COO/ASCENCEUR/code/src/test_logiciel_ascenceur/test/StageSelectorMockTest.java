package test_logiciel_ascenceur.test;

import logiciel_ascenseur.mock.cabin.StageSelectorMock;
import org.junit.Test;

import static org.junit.Assert.*;

public class StageSelectorMockTest {
    //this class has no responsability other than just
    //remembering one unique user selection at the time
    @Test
    public void getSelection(){
        StageSelectorMock selector = new StageSelectorMock();
        for(int i=0; i<10; i++){
            selector.setSelection(i);
            assertEquals(i, selector.getUserSelection());
        }
    }

}