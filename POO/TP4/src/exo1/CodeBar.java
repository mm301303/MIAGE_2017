package exo1;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CodeBar extends Applet{
    private Code39Word code39Word;
    private String word;
    private static final int HEIGHT = 100;
    private int cursor_value;

    @Override
    public void init() {
        super.init();
        System.out.println("Please enter a word :");
        Scanner sc = new Scanner(System.in);
        word="unknown";
        if(sc.hasNextLine()) word = sc.nextLine();
        else this.init();
        if(word.contains("*")) word = word.substring(word.indexOf('*')+1, word.lastIndexOf('*'));//wut am i am supposed to do with * ?
        System.out.println("word to translate : "+word);
        cursor_value=0;
    }

    public void paint (Graphics g) {
        g.drawString(word,10,10);
        fillCode39WordList();
        drawWord(g);
    }

    private void fillCode39WordList() {
        this.code39Word = new Code39Word(word);
    }

    private void drawWord(Graphics g) {
        Code39Word etoile = new Code39Word("*");
        for(Code39Part i : etoile.getParts()){
            drawPart(g, i);
        }
        for(Code39Part c : this.code39Word.getParts()   ){
           drawPart(g, c);
        }
        for(Code39Part j : etoile.getParts()){
            drawPart(g, j);
        }
    }

    private void drawPart(Graphics g, Code39Part code39Part) {
        Color color = Color.white;
        int width = Epaisseur.ETROIT;//tres tres laid =(
        if(code39Part.getNature() == Nature.BARRE) color= Color.black;
        if(code39Part.getEpaisseur() == Epaisseur.LARGE) width= Epaisseur.LARGE;
        g.setColor(color);
        g.fillRect(cursor_value,20,width, HEIGHT);
        cursor_value+=width;//the next will be drawn just after

    }

}
