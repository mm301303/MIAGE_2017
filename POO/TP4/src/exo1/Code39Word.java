package exo1;

public class Code39Word {
    protected final int Code39WordSize = 9;
    private Code39Part[] array;


    public Code39Word(String asciiWord) {
        this.array = new Code39Part[Code39WordSize];

    }
}
