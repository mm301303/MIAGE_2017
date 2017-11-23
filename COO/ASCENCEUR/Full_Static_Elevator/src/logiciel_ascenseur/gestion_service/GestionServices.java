package logiciel_ascenseur.gestion_service;

import logiciel_ascenseur.gestion_elem_composite.GestionCabines;

public abstract class GestionServices {
    static private class Service {
        public int numCabineServant;
        public int numEtageServi;
	    public ETypeService type;
    }

    private final static int NB_MAX_SERVICES = 1;
    private static Service[] lesServices = new Service[NB_MAX_SERVICES];
    
    public static void appel(int numEtage) {
        //...
        int numCabine = GestionCabines.obtenirCabineDisponible();
        if (numCabine != -1) {
            memoriserAppel(numCabine,numEtage, ETypeService.APPEL);
            GestionCabines.deplacerVers(numCabine,numEtage);
        }
        //...
    }

    public static void arriveeCabine(int numCabine, int numEtage) {
        /* Verifier s'il existe un service pour cet étage. 
         Dans cette version, il n'y a qu'un seul service au maximum.
         On ne verifie donc que la premiere entree de la liste */
        if (lesServices[0].numEtageServi == numEtage && lesServices[0].numCabineServant==numCabine) {
            GestionCabines.desservirEtage(lesServices[0].numCabineServant);
            detruireService();
        }
    }

    private static void memoriserAppel(int numCabine,int numEtage, ETypeService leType) {
        lesServices[0] = new Service();
        lesServices[0].numCabineServant = numCabine;
        lesServices[0].numEtageServi = numEtage;
        lesServices[0].type = leType;
    }

    private static void detruireService() {
        lesServices[0] = null; 
    }
}
