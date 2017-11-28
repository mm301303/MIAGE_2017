import java.applet.Applet;
import java.awt.*;
import java.util.Scanner;

public class CodeBar11 extends Applet{
    private Code11Word code11Word;
    private String word;
    private static final int HEIGHT = 100;
    private int cursor_value;
    private static int PETIT_ESPACEMENT = 1;

    @Override
    public void init() {
        super.init();
        System.out.println("Please enter a word :");
        Scanner sc = new Scanner(System.in);
        word="unknown";
        if(sc.hasNextLine()) word = sc.nextLine()+" ";
        else this.init();
        System.out.println("word to translate : ["+word+"]");
        word=word.substring(0,word.length()-1);
        System.out.println("sanitize : ["+word+"]");
        cursor_value=0;
    }

    public void paint (Graphics g) {
        g.drawString(word,10,10);
        fillCode11WordList();
        drawWord(g);
    }

    private void fillCode11WordList() {
        this.code11Word = new Code11Word(word);
    }

    private void drawWord(Graphics g) {


        for(Code11Part c : this.code11Word.getParts()   ){
           drawPart(g, c);
        }

    }

    private void drawPart(Graphics g, Code11Part code39Part) {
        Color color = Color.white;
        int width = Epaisseur.ETROIT_m;//tres tres laid =(
        if(code39Part.getNature() == Nature.BARRE) color= Color.black;
        if(code39Part.getEpaisseur() == Epaisseur.LARGE) width= Epaisseur.LARGE_m;
        g.setColor(color);
        g.fillRect(cursor_value,20,width, HEIGHT);
        cursor_value+=width+PETIT_ESPACEMENT;//the next will be drawn just after

    }

}
