package fr.unice.abr;

public interface IComplexe {
    double getModule();
    double getArgument();
    double getR();
    double getI();
    IComplexe add(IComplexe c);
    IComplexe sub(IComplexe c);
    IComplexe div(IComplexe c);
    IComplexe mult(IComplexe c);
}
