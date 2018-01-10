package fr.unice.abr;

public class ComplexeCartesien extends AbstractComplex{
    private double r, i;
    private IComplexe representation_polaire;

    public ComplexeCartesien(double r, double i) {
        this.r = r;
        this.i = i;
    }

    @Override
    public double getModule() {
        return Math.sqrt(r*r+i*i);
    }

    @Override
    public double getArgument() {
        this.representation_polaire = new ComplexePolaire(Math.acos(r/(getModule())), this.getModule());
        return representation_polaire.getArgument();
    }

    @Override
    public double getR() {
        return r;
    }

    @Override
    public double getI() {
        return i;
    }

}
