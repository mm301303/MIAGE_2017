package test_logiciel_ascenceur;
import logiciel_ascenseur.console.Display;
import logiciel_ascenseur.mock.PhysicalMockFactory;
import logiciel_ascenseur.mock.cabin.CabinMock;

public class SimulateurDriver {

    public static void main(String[] args) {
        // Initialisation: Ascenseur a 4 etages, dont le RDC
        // Cabine porte fermee, arretee a l'etage 1
        PhysicalMockFactory driverFactory = new PhysicalMockFactory();
        // Creation des boutons
        // Pour chaque bouton: creerBouton(int numBouton, int numEtage)
        driverFactory.creerBouton(0,0);
        driverFactory.creerBouton(1,1);
        driverFactory.creerBouton(2,2);
        driverFactory.creerBouton(3,3);
        // Creation de l'entrainement: creerEntrainement(int numEntrainement)
        driverFactory.creerEntrainement(0);
        // Creation des portes
        // Pour chaque porte: creerPorte(int numPorte, int numEtage, int numCabine)
        driverFactory.creerPorte(0,0,-1);
        driverFactory.creerPorte(1,1,-1);
        driverFactory.creerPorte(2,2,-1);
        driverFactory.creerPorte(3,3,-1);
        driverFactory.creerPorte(4,-1,0);
        // Creation des etages
        // Pour chaque etage: creerEtage(int numEtage, int numBouton, int numPorte)
        driverFactory.creerEtage(0, 0, 0);
        driverFactory.creerEtage(1, 1, 1);
        driverFactory.creerEtage(2, 2, 2);
        driverFactory.creerEtage(3, 3, 3);
        // Creation de la cabine: creerCabine(int numCabine, int numEntrainement, int numPorte, int numEtageCourant)
        driverFactory.creerCabine(0,0,4,1);
        //Affichage état cabine - vérification pré-conditions
        System.out.println("etat de la cabine: " + driverFactory.getEtatCabine(0).toString());
        System.out.println("etage courant de la cabine: " + driverFactory.getNumEtageCourant(0));
        System.out.println("");



        //Execution du scenario par simulation des drivers
        System.out.println("appel par le driver de la méthode notificationPression(bouton3) ");

        int numBouton = 3;
        driverFactory.notificationPression(numBouton);
        System.out.println("");

        //Affichage état cabine - vérification post-conditions
        System.out.println("etat de la cabine: " + driverFactory.getEtatCabine(0).toString());
        System.out.println("etage courant de la cabine: " + driverFactory.getNumEtageCourant(0));
        System.out.println("");
        /*
        Display.print("1 - 3");
        //suite
        CabinMock c = driverFactory.getCabins().get(0);
        c.setSelection(numBouton);
        for(int i=1; i<=numBouton;i++){
            c.notifyNewStage(i);
        }

        Display.print("\n**********\nretour au rdc");
        int newSelection =0;
        c.setSelection(newSelection);//retour au rdc
        for(int j=3; j>=newSelection;j--){
            c.notifyNewStage(j);
        }
    */
    }
}
