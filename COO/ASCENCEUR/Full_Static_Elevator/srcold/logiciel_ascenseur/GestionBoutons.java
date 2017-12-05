package logiciel_ascenseur;

public class GestionBoutons {
    private static boolean isInit = false;
    public static int[] boutons;

    private static int[] init() {
        boutons = new int[100];
        for(int i = 0; i<100; i++)
            boutons[i] = -1;
        return boutons;
    }

    public static void notificationPression(int i) {
        GestionEntrainements.goTo(GestionCabines.getTheOnlyFuckingOneCabin(), i);
    }

    public static void creerBouton(int i, int i1) {
        CreerBouton(i);
    }

    private static void CreerBouton(int i){
        if(!isInit) {
            boutons = init();
            isInit = true;
        }
        boutons[i]=i;
    }

}
