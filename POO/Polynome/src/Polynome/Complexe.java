package Polynome;

import org.omg.CORBA.IMP_LIMIT;

public class Complexe {
    private double Re, Im;

    public Complexe(double re, double im) {
        Re = re;
        Im = im;
    }

    @Override
    public String toString(){
        return "Z= "+Re+" + i*( "+ Im + ")";
    }
}
