package fr.unice.abr;

/**
 * This class is meant to reduce duplicated code using the easier way to compute operations on complex numbers
 */
public abstract class AbstractComplex implements IComplexe{

    public abstract double getModule();

    public abstract double getArgument();

    public abstract double getR();

    public abstract double getI();

    public IComplexe add(IComplexe c) {
        return new ComplexeCartesien(this.getR()+c.getR(), this.getI()+c.getI());
    }

    public IComplexe sub(IComplexe c) {
        return new ComplexeCartesien(this.getR()-c.getR(), this.getI()-c.getI());
    }

    public IComplexe div(IComplexe c) {
        return new ComplexePolaire(this.getArgument()-c.getArgument(), this.getModule()/c.getModule());
    }

    public IComplexe mult(IComplexe c) {
        return new ComplexePolaire(this.getArgument()+c.getArgument(), this.getModule()*c.getModule());
    }
}
