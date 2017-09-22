package logiciel_ascenseur.mock.Doors;

import java.util.ArrayList;

public class DoorManager {
    private ArrayList<DoorMock> stageDoors;
    private ArrayList<DoorMock> innerDoors;

    public DoorManager() {
        this.stageDoors = new ArrayList<>();
        this.innerDoors = new ArrayList<>();
    }

    public void createOuterDoor(int numPorte, int numEtage) {
        stageDoors.add(new DoorMock(numPorte));
    }

    public void createInnerDoor(int numporte, int numCabine) {
        innerDoors.add(new DoorMock(numporte));
    }

    public boolean isOuterDoorAt(int numPorte) {
        return numPorte<stageDoors.size();
    }
}
