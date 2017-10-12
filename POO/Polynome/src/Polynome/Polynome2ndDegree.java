package Polynome;

import java.util.ArrayList;
import java.util.List;

public class Polynome2ndDegree {
    private static final double DELTA = 0.0000001;
    private double a, b, c;
    private double discriminant;

    //default constructor
    public Polynome2ndDegree(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        computeDicriminant();
    }

    public Polynome2ndDegree(double a) {
        this(a,0.,0.);
    }

    public Polynome2ndDegree(double a, double b) {
        this(a, b,0.);
    }

    private void computeDicriminant(){
        this.discriminant = (b*b) - (4*a*c);
    }
    /**
     * Ajouter une méthode pour évaluer le polynôme.
     * On donne la valeur de x, la méthode nous donne la valeur de P(x).
     * Quelle est la signature de cette méthode ?
     */
    public double compute(double x){
        return (a*x*x)+(b*x)+c;
    }

    @Override
    public String toString(){
        return "P(x) = "+a+"x^2 + "+b+"x +"+c;
    }

    public void setA(double a) {
        this.a = a;
        computeDicriminant();
    }

    public void setB(double b) {
        this.b = b;
        computeDicriminant();
    }

    public void setC(double c) {
        this.c = c;
        computeDicriminant();
    }

    /**
     * Proposer deux méthodes (racineReelle1 et racineReelle2) qui donnent les deux racines réelles du polynôme ?
     * Que faut-t-il renvoyer lorsque le discriminant est négatif ?
     * getRoots()
     * @return a list containing 0, 1 or two double values according to the number of solutions
     */
    public List<Double> getRoots(){
        if(hasNoRoots()){
            return new ArrayList<>();//no result;
        }
        ArrayList<Double> roots = new ArrayList<>();
         if(hasDoubleRoot()){
            roots.add(-b/(2*a));
        }else if(hasTwoRoots()){//dans cet ordre, le double impose d'utiliser un delta
            //on ne peut donc pas tester si le discriminant est négatif avant
             roots.add(
                     (-b + Math.sqrt(discriminant))/(2*a)
             );
             roots.add(
                     (-b - Math.sqrt(discriminant))/(2*a)
             );
        }
        return roots;
    }

    public List<Complexe> getComplexRoots(){
        ArrayList<Complexe> roots = new ArrayList<>();
        if(hasNoRoots()) {
            roots.add(new Complexe(-b/2*a, -Math.sqrt(Math.abs(discriminant))/2*a));
            roots.add(new Complexe(-b/2*a, +Math.sqrt(Math.abs(discriminant))/2*a));
        }
        return roots;
    }

    private boolean hasTwoRoots() {
        return discriminant > 0;
    }

    private boolean hasDoubleRoot() {
        return discriminant<=DELTA || -discriminant>=DELTA;//= Math.abs
    }
    private boolean hasNoRoots() {
        return discriminant<0;
    }


}
