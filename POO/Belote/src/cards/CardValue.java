package cards;

public enum CardValue {

    AS("as"),
    ROI("roi"),
    DAME("dame"),
    VALET("valet"),
    DIX("10"),
    NEUF("neuf"),
    HUIT("huit"),
    SEPT("sept");

    public static final int[] nonAtoutValues = {
            11,
            4,
            3,
            2,
            10,
            0,
            0,
            0

    };

    public static final int[] atoutValues = {
            11,
            4,
            3,
            20,
            10,
            14,
            0,
            0

    };

    private String value;

    CardValue(String value) {
        this.value=value;
    }

    @Override
    public String toString() {
        return this.value;
    }


}
