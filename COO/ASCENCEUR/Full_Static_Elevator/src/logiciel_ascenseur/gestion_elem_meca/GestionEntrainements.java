package logiciel_ascenseur.gestion_elem_meca;

import logiciel_ascenseur.gestion_elem_composite.GestionCabines;

public abstract class GestionEntrainements {

    static private class Entrainement {
        private int numero;
        private int numCabine;
        private EEtatDep etatDeplacement;
    }
    private final static int NB_ENTRAINEMENTS = 1;
    private static Entrainement[] lesEntrainements = new Entrainement[NB_ENTRAINEMENTS];
    
    //Initialisation
    public static void creerEntrainement(int numEntrainement,int numCabine) {
        lesEntrainements[numEntrainement] = new Entrainement();
        lesEntrainements[numEntrainement].numero = numEntrainement;
        lesEntrainements[numEntrainement].numCabine = numCabine;
        lesEntrainements[numEntrainement].etatDeplacement = EEtatDep.ARRETE;
    }

    public static void notificationNouvelEtage(int numEntrainement, int numEtage) {
        GestionCabines.nouvelEtage(lesEntrainements[numEntrainement].numCabine, numEtage);
    }

    public static void arreter(int numEntrainement) {
        //Appeler le driver de l'entrainement ...
        System.out.println("appel de la méthode requeteArreter du driver pour l'entrainement numero: " + numEntrainement);
        lesEntrainements[numEntrainement].etatDeplacement = EEtatDep.ARRETE;
    }

    public static void descendre(int numEntrainement) {
        //Appeler le driver de l'entrainement ...
        System.out.println("appel de la méthode requeteDescendre du driver pour l'entrainement numero: " + numEntrainement);
        lesEntrainements[numEntrainement].etatDeplacement = EEtatDep.ENDESCENTE;
    }

    public static void monter(int numEntrainement) {
        System.out.println("appel de la méthode requeteMonter du driver pour l'entrainement numero: " + numEntrainement);
        lesEntrainements[numEntrainement].etatDeplacement = EEtatDep.ENMONTEE;
    }

    public static EEtatDep getEtatDeplacement(int numEntrainement) {
        return lesEntrainements[numEntrainement].etatDeplacement;
    }
}
