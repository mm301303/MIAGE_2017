package exo1;

public enum Nature {
    BARRE("black"),
    ESPACE("white");

    private String value;

    private Nature(String value){
        this.value=value;
    }
}
