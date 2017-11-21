package exo1;

public enum Epaisseur {
    LARGE("3"),
    ETROIT("1");

    private String value;

    private Epaisseur(String value){
        this.value = value;
    }
}
