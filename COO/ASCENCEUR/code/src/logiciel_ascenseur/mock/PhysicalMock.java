package logiciel_ascenseur.mock;

import logiciel_ascenseur.mock.Doors.DoorManager;
import logiciel_ascenseur.mock.cabin.CabinMock;
import logiciel_ascenseur.mock.cabin.CabinState;
import logiciel_ascenseur.mock.cabin.EngineMock;
import logiciel_ascenseur.mock.stage.ButtonMock;
import logiciel_ascenseur.mock.stage.StageMock;

import java.util.ArrayList;
import java.util.Comparator;

public class PhysicalMock {
    //Sorry for the french

    private ArrayList<StageMock> stages;
    private ArrayList<CabinMock> cabinMocks;
    private ArrayList<EngineMock> engine;
    private ArrayList<ButtonMock> buttons;
    private DoorManager doorManager;
    public PhysicalMock() {
        this.buttons = new ArrayList<>();
        this.stages = new ArrayList<>();
        this.cabinMocks = new ArrayList<>();
        this.engine = new ArrayList<>();
        this.doorManager = new DoorManager();
    }


    public void creerBouton(int numBouton, int numEtage) {
        if(numBouton==numEtage)
            buttons.add(new ButtonMock(numBouton));
    }

    public void creerEntrainement(int numCabin) {
        engine.add(new EngineMock());
    }
    //the correct field must be >0
    public void creerPorte(int numPorte, int numEtage, int numCabine) {
        if(numCabine==-1) doorManager.createOuterDoor(numPorte,numEtage);
        if(numEtage==-1) doorManager.createInnerDoor(numPorte,numCabine);
    }

    public void creerEtage(int numEtage, int numBouton, int numPorte) {
        if(numEtage>0&&buttons.get(numBouton)!=null&&doorManager.isOuterDoorAt(numPorte)){
            ArrayList<StageMock> copy = new ArrayList<>(stages);
            copy.add(new StageMock(numEtage,numBouton,numPorte));
            copy.sort(Comparator.comparing(StageMock::getEtage));
            stages=new ArrayList<>(copy);
        }

    }

    public void creerCabine(int numCabine, int numEntrainement, int numPorte, int numEtageCourant) {
        //numEntrainement ne me sert à rien
        if(engine.size()>numCabine)//car engine.size = cabins.size +1, l'engine doit etre créé avant
        {
            cabinMocks.add(new CabinMock(numCabine,numEtageCourant));
            cabinMocks.get(numCabine).setStage(numEtageCourant);
        }
    }

    public CabinState getEtatCabine(int numCabin) {
        return cabinMocks.get(numCabin).getState();
    }

    public int getNumEtageCourant(int numCabin) {
        return cabinMocks.get(numCabin).getStage();
    }

    //will contain scenario for call
    public void notificationPression(int numStage) {
    }

    //end of sorry


}
