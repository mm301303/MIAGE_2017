package test_logiciel_ascenceur;
import logiciel_ascenseur.mock.PhysicalMock;

public class SimulateurDriver {

    public static void main(String[] args) {
        // Initialisation: Ascenseur a 4 etages, dont le RDC
        // Cabine porte fermee, arretee a l'etage 1
        PhysicalMock p = new PhysicalMock();
        // Creation des boutons
        // Pour chaque bouton: creerBouton(int numBouton, int numEtage)
        p.creerBouton(0,0);
        p.creerBouton(1,1);
        p.creerBouton(2,2);
        p.creerBouton(3,3);
        // Creation de l'entrainement: creerEntrainement(int numEntrainement)
        p.creerEntrainement(0);
        // Creation des portes
        // Pour chaque porte: creerPorte(int numPorte, int numEtage, int numCabine)
        p.creerPorte(0,0,-1);
        p.creerPorte(1,1,-1);
        p.creerPorte(2,2,-1);
        p.creerPorte(3,3,-1);
        p.creerPorte(4,-1,0);
        // Creation des etages
        // Pour chaque etage: creerEtage(int numEtage, int numBouton, int numPorte)
        p.creerEtage(0, 0, 0);
        p.creerEtage(1, 1, 1);
        p.creerEtage(2, 2, 2);
        p.creerEtage(3, 3, 3);
        // Creation de la cabine: creerCabine(int numCabine, int numEntrainement, int numPorte, int numEtageCourant)
        p.creerCabine(0,0,4,1);
        //Affichage état cabine - vérification pré-conditions
        System.out.println("etat de la cabine: " + p.getEtatCabine(0).toString());
        System.out.println("etage courant de la cabine: " + p.getNumEtageCourant(0));
        System.out.println("");


        //Execution du scenario par simulation des drivers
        System.out.println("appel par le driver de la méthode notificationPression(bouton3) ");
        p.notificationPression(3);
        System.out.println("");

        //Affichage état cabine - vérification post-conditions
        System.out.println("etat de la cabine: " + p.getEtatCabine(0).toString());
        System.out.println("etage courant de la cabine: " + p.getNumEtageCourant(0));
        System.out.println("");
    }
}
