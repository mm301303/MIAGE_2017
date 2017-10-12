package logiciel_ascenseur.mock.cabin;

import logiciel_ascenseur.console.Display;

public class StageSelectorMock {
    private int userSelection;

    public StageSelectorMock() {
        this.userSelection = -1;
    }
    //ways of setting a value (user input or method call)
    public int getSelection(){
        Display.print("Please enter a stage number :");
        return Display.getInt();
    }
    //for semantic...
    public void setSelection(int i){
       this.userSelection=i;
    }
    //getter
    public int getUserSelection() {
        return userSelection;
    }
}
