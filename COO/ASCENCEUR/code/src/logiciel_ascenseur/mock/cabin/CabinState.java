package logiciel_ascenseur.mock.cabin;

public enum CabinState {

    ARRET_OUVERT ("ARRETE_OUVERT"),
    ARRET_FERME ("ARRETE_FERME"),
    EN_MONTEE ("ENMONTEE_FERME"),
    EN_DESCENTE ("ENDESCENTE_FERME");

    private String value;

    CabinState(String value) {
        this.value=value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
