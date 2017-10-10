package Polynome;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Polynome2ndDegreeTest {
    @Test
    public void testCompute(){
        Polynome2ndDegree p1 = new Polynome2ndDegree(1);//x^2
        Polynome2ndDegree p2 = new Polynome2ndDegree(1, 1);//x^2 + x
        Polynome2ndDegree p3 = new Polynome2ndDegree(1, 1, 1);//x^2 + x + 1
        ArrayList<Double> p1List = new ArrayList<>(p1.getRoots());
        ArrayList<Double> p2List = new ArrayList<>(p2.getRoots());
        ArrayList<Double> p3List = new ArrayList<>(p3.getRoots());
        System.out.println(p1.toString());
        assertEquals(p1List.size(),1);
        System.out.println(p2.toString());
        assertEquals(p2List.size(),2);
        System.out.println(p3.toString());
        assertEquals(p3List.size(),0);

    }

    @Test
    public void testComputeComplexe(){
        Polynome2ndDegree p3 = new Polynome2ndDegree(1, 1, 1);//x^2 + x + 1
        ArrayList<Complexe> res = new ArrayList<>(p3.getComplexRoots());
        assertEquals(2, res.size());
        System.out.println("complex test");
        display(p3);
        for(Complexe c : res) System.out.println(c.toString());

    }

    private void display(Polynome2ndDegree p){
        System.out.println(p.toString());
    }
}