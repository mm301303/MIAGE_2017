package exo1;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

public class CodeBar extends Applet{
    private ArrayList<Code39Word> code39WordList;

    public void paint (Graphics g) {
        g.drawString ("Hello World", 25, 50);
    }

}
