package utils;

import java.awt.*;

public class Cercle extends GeometricFigure {
    private int rayon;

    public Cercle(int rayon, double x, double y) {
        super(x, y);
        this.rayon = rayon;
        this.aire = (float) (Math.PI*this.rayon*this.rayon);
        this.perimetre = (float) Math.PI*2*this.rayon;
    }

    @Override
    public String toString() {
        return "Salut, je suis un "+ this.getClass().getSimpleName()+" :"+super.toString();
    }

    @Override
    public void draw(Graphics g){
        super.draw(g);
        g.drawOval((int)x, (int)y , this.rayon, this.rayon);
        setBackground(g);
    }

    @Override
    public void setBackground(Graphics g){
        background(g);
        g.fillOval((int)x+1, (int)y+1 , this.rayon,this.rayon);
    }
}
