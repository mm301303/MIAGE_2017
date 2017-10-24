package logiciel_ascenseur.mock.cabin;

public enum CabinState {

    ARRET_OUVERT ("Arretée, portes ouvertes"),
    ARRET_FERME ("Arretée, portes fermées"),
    EN_MONTEE ("En montée, portes fermées"),
    EN_DESCENTE ("En descente, portes fermées");

    private String value;

    CabinState(String value) {
        this.value=value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
