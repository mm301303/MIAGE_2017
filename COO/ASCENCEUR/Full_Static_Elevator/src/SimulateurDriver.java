import logiciel_ascenseur.*;

public class SimulateurDriver {

    public static void main(String[] args) {
	// Initialisation: Ascenseur a 4 etages, dont le RDC
        // Cabine porte fermee, arretee a l'etage 1
        
        // Creation des boutons
        // Pour chaque bouton: creerBouton(int numBouton, int numEtage)
        GestionBoutons.creerBouton(0,0);
        GestionBoutons.creerBouton(1,1);
        GestionBoutons.creerBouton(2,2);
        GestionBoutons.creerBouton(3,3);
        // Creation de l'entrainement: creerEntrainement(int numEntrainement,int numCabine)
        GestionEntrainements.creerEntrainement(0,0);
        // Creation des portes
        // Pour chaque porte: creerPorte(int numPorte, int numEtage, int numCabine)
        GestionPortes.creerPorte(0,0,-1);
        GestionPortes.creerPorte(1,1,-1);
        GestionPortes.creerPorte(2,2,-1);
        GestionPortes.creerPorte(3,3,-1);
        GestionPortes.creerPorte(4,-1,0);
        // Creation des etages
        // Pour chaque etage: creerEtage(int numEtage, int numBouton, int numPorte)
        GestionEtages.creerEtage(0, 0, 0);
        GestionEtages.creerEtage(1, 1, 1);
        GestionEtages.creerEtage(2, 2, 2);
        GestionEtages.creerEtage(3, 3, 3);
        // Creation de la cabine: creerCabine(int numCabine, int numEntrainement, int numPorte, int numEtageCourant)
        GestionCabines.creerCabine(0,0,4,1);
        //Affichage état cabine - vérification pré-conditions
        System.out.println("etat de la cabine: " + GestionCabines.getEtatCabine(0).toString());
        System.out.println("etage courant de la cabine: " + GestionCabines.getNumEtageCourant(0));
        System.out.println("");
        

        //Execution du scenario par simulation des drivers
        System.out.println("appel par le driver de la méthode notificationPression(bouton3) ");
        GestionBoutons.notificationPression(3);
        System.out.println("");

        System.out.println("appel par le driver de la méthode notificationNouvelEtage(entrainement0,etage2) par le driver");
        GestionEntrainements.notificationNouvelEtage(0, 2);
        System.out.println("");

        System.out.println("appel par le driver de la méthode notificationNouvelEtage(entrainement0,etage3) par le driver");
        GestionEntrainements.notificationNouvelEtage(0, 3);
        System.out.println("");
        
        //Affichage état cabine - vérification post-conditions
        System.out.println("etat de la cabine: " + GestionCabines.getEtatCabine(0).toString());
        System.out.println("etage courant de la cabine: " + GestionCabines.getNumEtageCourant(0));
        System.out.println("");
    }

}
