package logiciel_ascenseur;

import logiciel_ascenseur.GestionEtages;
import logiciel_ascenseur.GestionCabines;

public abstract class GestionBoutons {
    static private class Bouton {
        private int numero;
        private int numEtage;
        private EEtatBouton etatBouton;
    }
    private final static int NB_BOUTONS = 4;
    private static Bouton [] lesBoutons = new Bouton [NB_BOUTONS];
    
    //Initialisation
    public static void creerBouton(int numBouton, int numEtage) {
        lesBoutons[numBouton] = new Bouton();
        lesBoutons[numBouton].numero = numBouton;
        lesBoutons[numBouton].numEtage = numEtage;
    }
    
    public static void notificationPression(int numBouton) {
        //...
        GestionEtages.pression(lesBoutons[numBouton].numEtage, numBouton);
        //...
    }
}