package logiciel_ascenseur.mock.cabin;

public enum CabinState {

    ARRET_OUVERT ("arret_ouvert"),
    ARRET_FERME ("arret_ferme"),
    EN_MONTEE ("en montee"),
    EN_DESCENTE ("en descente");

    private String value;

    CabinState(String value) {
        this.value=value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
