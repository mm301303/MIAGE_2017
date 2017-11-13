import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.exit;

public class Vecteur{
private int[] terms;
    public Vecteur(Integer... args) {
        if(args.length<2) {
            System.out.println("un vecteur contient deux dimensions au minimum !");
            exit(1); //baaah
        }

        terms = new int[args.length];
        for(int i=0; i<args.length; i++){
            terms[i] = args[i];
        }
    }

    /**
     * renvoie l'index de l'élément recherché ou -1 si non présent
     * dans un tableau supposé non trié...
     * dans le pire des cas on a une complexité fonction de n
     */
    public int recherche(int value){
       return recherche(value, 0, terms.length);
    }

    private int recherche(int value, int debut, int fin){
        int j=-1;
        for(Integer i:terms) {
            j++;
            if (i.intValue() == value) break;
        }
        return j;
    }

    public int rechercheDichotomique(Integer value){
        return rechercheDichotomique(value, 0, terms.length-1);
    }

    private int rechercheDichotomique(Integer value, int start, int end){
        if(end - start > 2) {
            System.out.println("recurse : "+ (int)(end-start));
            if (value < terms[(start+end)/2]) {
                return rechercheDichotomique(value, start, (start+end)/2);
            } if(value > terms[(start+end)/2]) {
                return rechercheDichotomique(value, (start + end) / 2, end);
            }else {
                System.out.println("equality found "+ start +" ; "+ end);
                return (start+end)/2;
            }
        }
        return recherche(value);
    }

}
