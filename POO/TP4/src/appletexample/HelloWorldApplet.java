package appletexample;

import java.awt.*;
import java.applet.Applet;


public class HelloWorldApplet extends Applet{

    public HelloWorldApplet() throws HeadlessException {

        paint(super.getGraphics());

    }
/*
    @Override
    public void start(){
        super.start();
        paint(super.getGraphics());
    }
    */

    public void paint(Graphics g) {
        g.drawString("Hello world!", 50, 25);
    }
}
