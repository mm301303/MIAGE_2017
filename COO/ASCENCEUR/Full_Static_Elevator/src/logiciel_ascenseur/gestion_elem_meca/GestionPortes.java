package logiciel_ascenseur.gestion_elem_meca;



public abstract class GestionPortes {
    static private class Porte {
        private int numero;
        private int numEtage;
        private int numCabine;
        private EEtatOuv etatOuverture;
    }
    
    private final static int NB_PORTES = 5;
    private static Porte[] lesPortes = new Porte[NB_PORTES];
    
    //Initialisation
    public static void creerPorte(int numPorte,int numEtage, int numCabine) {
        lesPortes[numPorte] = new Porte();
        lesPortes[numPorte].numero = numPorte;
        lesPortes[numPorte].etatOuverture = EEtatOuv.FERMEE;
        lesPortes[numPorte].numEtage = numEtage;
        lesPortes[numPorte].numCabine = numCabine;
    }

    public static void fermer(int numPorte) {
        //Appel du driver
        System.out.println("appel de la méthode requeteFermer du driver pour la porte numero: " + numPorte);
        lesPortes[numPorte].etatOuverture = EEtatOuv.FERMEE;
    }

    public static void ouvrir(int numPorte) {
        //Appel du driver
        System.out.println("appel de la méthode requeteOuvrir du driver pour la porte numero: " + numPorte);
        lesPortes[numPorte].etatOuverture = EEtatOuv.OUVERT;
    }

    public static EEtatOuv getEtatOuv(int numPorte) {
        return lesPortes[numPorte].etatOuverture;
    }
}