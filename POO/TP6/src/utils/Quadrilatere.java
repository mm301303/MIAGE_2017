package utils;

import java.awt.*;

public class Quadrilatere extends GeometricFigure {

    public Quadrilatere(double x, double y) {
        super( x, y);
        this.perimetre = 2*H + 2*L;
        this.aire = H*L;
    }

    @Override
    public String toString() {
        return "Salut, je suis un"+ this.getClass().getSimpleName()+" :"+super.toString();
    }

    @Override
    public void draw(Graphics g){
        super.draw(g);
        g.drawRect((int)x, (int)y, H, L);
        setBackground(g);
    }

    @Override
    public void setBackground(Graphics g) {
        background(g);
        g.fillRect((int)x+1, (int)y+1, H-1, L-1);
    }
}
