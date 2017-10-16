package logiciel_ascenseur;


public abstract class GestionEtages {
    static private class Etage {
        private int numero;
        private int numPorteEtage;
        private int numBoutonAppel;
        private boolean estEnService;
    }
    private final static int NB_ETAGES = 4;
    private static Etage[] lesEtages = new Etage[NB_ETAGES];
    
    //Initialisation
    public static void creerEtage(int numEtage, int numBoutonAppel, int numPorteEtage) {
        lesEtages[numEtage] = new Etage();
        lesEtages[numEtage].numero = numEtage;
        lesEtages[numEtage].estEnService = true;
        lesEtages[numEtage].numBoutonAppel = numBoutonAppel;
        lesEtages[numEtage].numPorteEtage = numPorteEtage;
    }

    public static void pression(int numEtage, int numBoutonPresse) {
        //...
        if (numBoutonPresse == lesEtages[numEtage].numBoutonAppel && lesEtages[numEtage].estEnService) {
            GestionServices.appel(numEtage);
        }
        //...
    }
}