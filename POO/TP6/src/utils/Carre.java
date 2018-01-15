package utils;

import utils.Quadrilatere;

import java.awt.*;

public class Carre extends Quadrilatere {


    public Carre(double x, double y) {
        super(x, y);
        this.aire = H*H;
    }

    @Override
    public String toString() {
        return "Salut, je suis un "+ this.getClass().getSimpleName()+" :"+super.toString();
    }

    @Override
    public void draw(Graphics g){
        //super.draw(g);
        g.setColor(TRAIT);
        g.drawRect((int)x, (int)y, H, H);
        setBackground(g);
    }

    @Override
    public void setBackground(Graphics g){
        background(g);
        g.fillRect((int)x+1, (int)y+1, H-1, H-1);

    }

}
