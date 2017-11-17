package logiciel_ascenseur;

public class GestionEntrainements {
    public static void notificationNouvelEtage(int entrainement, int etage) {
        GestionCabines.ETAGE_COURANT = etage;
        
        System.out.println("etage : "+GestionCabines.ETAGE_COURANT);
    }

    public static void creerEntrainement(int i, int j) {
        //rien
    }

    public static void goTo(int theOnlyFuckingOneCabin, int i) {
        GestionCabines.DESTINATION = i;
        if(i<GestionCabines.ETAGE_COURANT){
            //on descends
            GestionCabines.ETAT_COURANT = GestionCabines.etats[3];
        }else if(i>GestionCabines.ETAGE_COURANT){
            //on monte
            GestionCabines.ETAT_COURANT = GestionCabines.etats[2];
        }if(GestionCabines.DESTINATION == GestionCabines.ETAGE_COURANT){
            //on y est
            GestionCabines.ETAT_COURANT = GestionCabines.etats[0];//arrete ferme
            System.out.println("Attention a l'ouverture des portes");
            GestionCabines.ETAT_COURANT = GestionCabines.etats[1];//arrete ouvert
        }
    }
}
