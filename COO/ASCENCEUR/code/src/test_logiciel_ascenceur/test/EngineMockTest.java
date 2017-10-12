package test_logiciel_ascenceur.test;

import logiciel_ascenseur.mock.cabin.EngineMock;

import static org.junit.Assert.*;

public class EngineMockTest {
    @org.junit.Test
    public void getNormalState(){
        EngineMock engine = new EngineMock();
        //must be created in stopped state : or else it would be dangerous
        checkStopped(engine);

        engine.goUp();
        checkGoingUp(engine);

        engine.stop();
        checkStopped(engine);

        engine.goDown();
        checkGoingDown(engine);

        engine.stop();
        checkStopped(engine);
    }


    @org.junit.Test
    public void inCaseYoureASavage(){
        EngineMock engine = new EngineMock();
        //must be created in stopped state : or else it would be dangerous
        checkStopped(engine);

        engine.goUp();
        checkGoingUp(engine);

        engine.goDown();
        checkGoingDown(engine);

        engine.goUp();
        checkGoingUp(engine);

        engine.goDown();
        checkGoingDown(engine);

    }

    private void checkStopped(EngineMock engine){
        assertEquals(true, engine.isStopped());
    }
    private void checkGoingUp(EngineMock engine){
        assertEquals(true, engine.isGoingUp());
    }
    private void checkGoingDown(EngineMock engine){
        assertEquals(true, engine.isGoingDown());
    }


}