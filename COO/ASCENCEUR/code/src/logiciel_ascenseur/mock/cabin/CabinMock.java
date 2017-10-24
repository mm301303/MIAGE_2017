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
        this.state = CabinState.ARRET_FERME;//ready, doors opened
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
        engine.goDown();
    }

    public void setRisingState() {
        engine.goUp();
    }

    public void setStoppedState() {
        engine.stop();
        state = CabinState.ARRET_OUVERT;
    }

    public void notifyNewStage(int i){
        this.setStage(i);

        if(stage==stageSelector.getUserSelection()){
            setStoppedState();
        }else{
            //engine is moving
            if(engine.isGoingUp){
                setRisingState();
            }
            if(engine.isGoingDown){
                setDescendingState();
            }
            state = engine.getState();
        }
        Display.print("--------\nCurrent stage : " + stage);
        Display.print("Current state : " + state);
        Display.print("--------");

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
