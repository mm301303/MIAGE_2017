package logiciel_ascenseur;

import logiciel_ascenseur.GestionCabines;

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
        int numCabine = GestionCabines.getCabineArreteFerme();
        if (numCabine != -1) {
            memoriserAppel(numCabine,numEtage, ETypeService.APPEL);
            GestionCabines.deplacerVers(numCabine,numEtage);
        }
        //...
    }

    private static void memoriserAppel(int numCabine,int numEtage, ETypeService leType) {
        lesServices[0] = new Service();
        lesServices[0].numCabineServant = numCabine;
        lesServices[0].numEtageServi = numEtage;
        lesServices[0].type = leType;
    }
}
