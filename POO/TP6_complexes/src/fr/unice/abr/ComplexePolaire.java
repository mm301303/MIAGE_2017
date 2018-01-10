package fr.unice.abr;

public class ComplexePolaire extends AbstractComplex{
    double theta, module;
    IComplexe representation_cart;

    public ComplexePolaire(double theta, double module) {
        this.theta = theta;
        this.module = module;

    }

    @Override
    public double getModule() {
        return this.module;
    }

    @Override
    public double getArgument() {
        return this.theta;
    }

    @Override
    public double getR() {
        double r = module*Math.cos(theta);
        double i = module*Math.sin(theta);
        representation_cart = new ComplexeCartesien(r, i);
        return representation_cart.getR();
    }

    @Override
    public double getI() {
        double r = module*Math.cos(theta);
        double i = module*Math.sin(theta);
        representation_cart = new ComplexeCartesien(r, i);
        return representation_cart.getI();
    }

    /*
    @Override
    public IComplexe add(IComplexe c) {
        return new ComplexeCartesien(representation_cart.getR()+c.getR(), representation_cart.getI()+c.getI());
    }

    @Override
    public IComplexe sub(IComplexe c) {
        return new ComplexeCartesien(representation_cart.getR()-c.getR(), representation_cart.getI()-c.getI());
    }

    @Override
    public IComplexe div(IComplexe c) {
        return new ComplexePolaire(theta-c.getArgument(), module/c.getModule());
    }

    @Override
    public IComplexe mult(IComplexe c) {
        return new ComplexePolaire(theta+c.getArgument(), module*c.getModule());
    }
    */
}
