package logiciel_ascenseur.mock.cabin;

public class CabinMock {
    private CabinState state;
    private int innerDoor;
    private StageSelectorMock stageSelector;
    private int stage;

    public CabinMock(int innerDoor, int stage) {
        this.innerDoor = innerDoor;
        this.stage = stage;
        this.stageSelector = new StageSelectorMock();
        this.state = CabinState.ARRET_OUVERT;//ready
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

}
