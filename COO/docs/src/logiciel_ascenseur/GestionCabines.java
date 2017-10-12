package logiciel_ascenseur;

public abstract class GestionCabines {
    static private class Cabine {
        private int numero;
        private int numEtageCourant;
        private int numEntrainement;
        private int numPorteCabine;
    }
    private final static int NB_CABINES = 1;
    private static Cabine[] lesCabines = new Cabine[NB_CABINES];
    
    //Initialisation
    public static void creerCabine(int numCabine, int numEntrainement, int numPorteCabine, int numEtageCourant) {
        lesCabines[numCabine] = new Cabine();
        lesCabines[numCabine].numero = numCabine;
        lesCabines[numCabine].numEntrainement = numEntrainement;
        lesCabines[numCabine].numPorteCabine = numPorteCabine;
        lesCabines[numCabine].numEtageCourant = numEtageCourant;
    }

    public static void deplacerVers(int numCabine,int numEtageDepl) {
        if (lesCabines[numCabine].numEtageCourant < numEtageDepl) {
            GestionEntrainements.monter(lesCabines[numCabine].numEntrainement);
        } else if (lesCabines[numCabine].numEtageCourant > numEtageDepl) {
            GestionEntrainements.descendre(lesCabines[numCabine].numEntrainement);
        } else {
            //Ouvrir les portes
        }
    }
    
    public static int getNumEtageCourant(int numCabine) {
        return lesCabines[numCabine].numEtageCourant;
    }

    public static EEtatCabine getEtatCabine(int numCabine) {
        EEtatCabine etatCabine;
        EEtatOuv etatOuv = GestionPortes.getEtatOuv(lesCabines[numCabine].numPorteCabine);
        EEtatDep etatDepl = GestionEntrainements.getEtatDeplacement(lesCabines[numCabine].numEntrainement);
        if (etatDepl == EEtatDep.ENDESCENTE) {
            etatCabine = EEtatCabine.ENDESCENTE_FERME;
        } else if (etatDepl == EEtatDep.ENMONTEE) {
            etatCabine = EEtatCabine.ENMONTEE_FERME;
        } else if (etatDepl == EEtatDep.ARRETE) {
            if (etatOuv == EEtatOuv.OUVERT) {
                etatCabine = EEtatCabine.ARRETE_OUVERT;
            } else {
                etatCabine = EEtatCabine.ARRETE_FERME;
            }
        } else //pb?
        {
            etatCabine = EEtatCabine.ARRETE_FERME;
        }
        return etatCabine;
    }
    
    public static int getCabineArreteFerme(){
        if (getEtatCabine(0) == EEtatCabine.ARRETE_FERME){
            return 0;
        }
        else return -1;
    }
}