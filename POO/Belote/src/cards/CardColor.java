package cards;

public enum CardColor {

    TREFLE("Trèfle"),
    PIQUE("Pique"),
    CARREAU("Carreau"),
    COEUR("Coeur");

    private String value;

    CardColor(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }


}
