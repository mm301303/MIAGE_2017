package logiciel_ascenseur;

import jdk.internal.org.objectweb.asm.commons.GeneratorAdapter;

public class GestionCabines {
    public static final String[] etats = { "Arreté fermé",
            "Arreté ouvert",
            "En montée fermée",
            "En descente fermée"};
    public static int DESTINATION = 1;

    public static String ETAT_COURANT = "Arreté fermé";
    public static int ETAGE_COURANT = 1;

    public static String getEtatCabine(int i) {
        return GestionCabines.ETAT_COURANT;
    }

    public static String getNumEtageCourant(int i) {
        return "Etage courant : "+ GestionCabines.ETAGE_COURANT;
    }

    public static void creerCabine(int i, int i1, int i2, int i3) {
        ETAT_COURANT = etats[0];
        ETAGE_COURANT = 1;
    }

    public static int getTheOnlyFuckingOneCabin() {
        return 1;
    }
}
