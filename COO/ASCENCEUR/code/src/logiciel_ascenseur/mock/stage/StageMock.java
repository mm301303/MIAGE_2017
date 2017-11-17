package logiciel_ascenseur.mock.stage;


import logiciel_ascenseur.mock.cabin.CabinMock;
import logiciel_ascenseur.mock.cabin.StageSelectorMock;

public class StageMock {
    private int number;
    private int numPorte;

    public StageMock(int numEtage, int numBouton, int numPorte) {
        this.number = numEtage;
        this.numPorte = numPorte;
    }

    public int getEtage() {
        return number;
    }

    /**
     * when an user is at a stage he can call the cabin by pressing the call button
     */
    public void pressButton(StageSelectorMock cabinStageSelector){
        cabinStageSelector.setSelection(this.number);
    }
}
