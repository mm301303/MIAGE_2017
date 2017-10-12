package logiciel_ascenseur.mock.stage;


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
}
