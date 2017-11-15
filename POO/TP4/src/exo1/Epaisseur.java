package exo1;

public enum Epaisseur {
    LARGE("30px"),
    ETROIT("10px");

    private String value;

    private Epaisseur(String value){
        this.value = value;
    }
}
