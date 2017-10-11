package Random;

import java.util.Random;

/**
 * a, b et n sont des entiers tels que n est positif et non nul, b est supérieur ou égal à a.
 * Utiliser le mécanisme d'assertion vu en cours pour imposer ces contraintes.
 * On ne fait aucune supposition sur le signe de a et b.
 */
public class Randomizer {


    public static void main(String[] args) {
	    // Générer pseudo-aléatoirement un nombre entier dans l'intervalle [0; 50]
        displayres(0, 50);
        // Générer pseudo-aléatoirement un nombre entier dans l'intervalle ]-20; 50]
        displayres(-20, 50);
        // Générer pseudo-aléatoirement un nombre entier dans l'intervalle [a;b]
        System.out.println(":)");
        // Générer pseudo-aléatoirement un nombre entier pair dans l'intervalle [a; b]
        int a=0, b=100;
        System.out.println("Random pair : " + generateIntegerBetween_1stImpl(a/2, b/2)*2);
        // Générer pseudo-aléatoirement un nombre entier multiple de n dans l'intervalle [a; b]
        for(int n=1; n<10; n++)
            System.out.println("Random multiple de "+n+" : " + generateIntegerBetween_1stImpl(a/n, b/n)*n);
    }

    private static void displayres(int a, int b) {
        System.out.println("* intervalle ["+a+";"+b+"] :\n");
        System.out.println("util.Random : " + generateIntegerBetween_1stImpl(a,b) );
        System.out.println("Math.random : " + generateIntegerBetween_2stImpl(a,b) );
    }

    //with Random
    private static int generateIntegerBetween_1stImpl(int a, int b){
        int res = 0;
        Random random = new Random();
        int A,B;
        if(a>b){
            A = a;
            B = b;
        }else{
            A=b;
            B=a;
        }
        res = random.nextInt()%(B-A)+A;
        return res;

    }
    //with Math.random()
    private static int generateIntegerBetween_2stImpl(int a, int b){
        int res = 0;
        int A,B;
        if(a>b){
            A = a;
            B = b;
        }else{
            A=b;
            B=a;
        }
        res = (int)(Math.random()*(B-A)+A);
        return res;
    }
}
