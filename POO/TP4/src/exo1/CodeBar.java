package exo1;

import org.alphabet.Alphabet;
import org.alphabet.AlphabetConverter;
import org.alphabet.Word;
import org.alphabet.alphabets.ASCII;
import org.alphabet.alphabets.Code39;

import java.applet.Applet;

public class CodeBar {
    //private Applet applet; //ca je fais pas, valeur ajoutée 0 et classnotfoundexception qui casse les couilles
    private String asciiArt;
    public CodeBar(String src) {
        Alphabet<ASCII> asciiAlphabet = new ASCII();
        Alphabet<Code39> code39Alphabet = new Code39();


        Word<ASCII> word = asciiAlphabet.createWord(src.toUpperCase());
        word.convert().to(code39Alphabet);

        System.out.println(word.getWord()+";\n"+word.toString()+";\n"+word.getAlphabet());
        setValue(word.getWord());
    }

    public void setValue(String value){
        if(value.length()<=9){
            asciiArt=value;
        }else throw new RuntimeException("Operation aborted : the string must be of length 9 chars");

    }

    public String getAsciiArt() {
        return asciiArt;
    }
}
