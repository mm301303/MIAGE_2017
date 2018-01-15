package utils;

import java.awt.*;

public class Elipse extends GeometricFigure {


    public Elipse(double x, double y, double A, double B) {
        super(x, y);

        this.aire = (float) (Math.PI*B*A);
        this.perimetre = (float) (Math.PI*Math.sqrt(B*B+A*A));

    }

    @Override
    public String toString() {
        return "Salut, je suis une "+ this.getClass().getSimpleName()+" :"+super.toString();
    }

    @Override
    public void draw(Graphics g){
        super.draw(g);
        g.drawOval((int)x, (int)y, L,H);
        setBackground(g);
    }
    @Override
    public void setBackground(Graphics g) {
        background(g);
        g.fillOval((int) x + 1, (int) y + 1, L-1, H - 1);
    }
}
