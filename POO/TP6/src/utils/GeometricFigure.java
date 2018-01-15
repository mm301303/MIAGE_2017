package utils;

import java.awt.*;

public class GeometricFigure {

    protected final static int L = 30;
    protected final static int H = 50; // to be used in the rest

    protected final Color BACKGROUND_COLOR = Color.RED;
    protected final Color TRAIT = Color.GREEN;


    public double aire, perimetre, x, y;

    public GeometricFigure(double x, double y){
        this.x = x;
        this.y = y;
        this.perimetre = -1;
        this.aire = -1;
    }
    public GeometricFigure(float aire, float perimetre, float x, float y) {
        this.aire = aire;
        this.perimetre = perimetre;
        this.x = x;
        this.y = y;
        System.out.println("perimetre = " + perimetre);
        System.out.println("x = " + x);
    }

    @Override
    public String toString() {
        return "aire = " + aire+" perimetre = " + perimetre+ " x = " + x+ "y = " + y;
    }

    public void draw(Graphics g){
        g.setColor(TRAIT);
    }

    public void setBackground(Graphics g){
        System.out.println("To be overridden");
    }

    protected void background(Graphics g){
        g.setColor(BACKGROUND_COLOR);
    }
}
