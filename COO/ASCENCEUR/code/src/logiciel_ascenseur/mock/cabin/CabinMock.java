package logiciel_ascenseur.mock.cabin;

import logiciel_ascenseur.console.Display;

public class CabinMock {
    private CabinState state;
    private int innerDoor;
    private StageSelectorMock stageSelector;
    private int stage;
    private EngineMock engine;

    public CabinMock(int innerDoor, int stage, EngineMock engine) {
        this.innerDoor = innerDoor;
        this.stage = stage;
        this.stageSelector = new StageSelectorMock();
        this.state = CabinState.ARRET_OUVERT;//ready
        //this is awful
        this.engine = engine; //we cannot have several cabins...
    }

    public CabinState getState() {
        return state;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public void setDescendingState() {
        state = CabinState.EN_DESCENTE;
        engine.isGoingDown();

    }

    public void setRisingState() {
        state = CabinState.EN_MONTEE;
        engine.isGoingUp();

    }

    public void setStoppedState() {
        this.state = CabinState.ARRET_OUVERT;
        engine.stop();
    }

    public void notifyNewStage(int i){
        this.setStage(i);
        if(!state.equals(CabinState.ARRET_OUVERT)){
            //engine is moving
            if(engine.isGoingUp){
                setRisingState();
            }
            if(engine.isGoingDown){
                setDescendingState();

            }
        }
        if(stage==stageSelector.getUserSelection()){
            setStoppedState();
        }

        Display.print("\n--------\ncurrent stage" + stage);
        Display.print("current state" + state);
    }

    public StageSelectorMock getStageSelector() {
        return stageSelector;
    }

    public void setSelection(int selection) {
        if(selection<stage) setDescendingState();
        if(selection>stage) setRisingState();
        if(selection==stage) setStoppedState();
        this.stageSelector.setSelection(selection);
    }
}
