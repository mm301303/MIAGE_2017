package exo1;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CodeBar extends Applet{
    private Code39Word code39Word;
    private String word;
    private static final int HEIGHT = 50;
    private static final int WIDTH = 200;
    private int cursor_value;

    @Override
    public void init() {
        super.init();
        System.out.println("Please enter a word :");
        Scanner sc = new Scanner(System.in);
        word="unknown";
        if(sc.hasNextLine()) word = sc.nextLine();
        else this.init();

        cursor_value=0;
    }

    public void paint (Graphics g) {
        g.drawString(word,10,10);
        g.drawRect (0, 20, WIDTH, HEIGHT);
        fillCode39WordList();
        drawWord(g);
    }

    private void fillCode39WordList() {
        this.code39Word = new Code39Word(word);
    }

    private void drawWord(Graphics g) {
        for(Code39Part c : this.code39Word.getParts()){
            for(int i=0; i<9; i++){
                drawPart(g, c.getParts().get(i));
            }
        }
    }

    private void drawPart(Graphics g, Code39Part code39Part) {
        Color color = Color.white;
        int width = Integer.parseInt(Epaisseur.ETROIT.toString());//tres tres laid =(

        if(code39Part.getNature()==Nature.BARRE) color= Color.black;
        if(code39Part.getEpaisseur()==Epaisseur.LARGE) width=Integer.parseInt(Epaisseur.LARGE.toString());


        cursor_value+=width;//the next will be drawn just after
        g.setColor(color);
        g.fillRect(cursor_value,20,width, HEIGHT);

    }

}
