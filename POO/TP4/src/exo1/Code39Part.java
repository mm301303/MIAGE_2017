package exo1;


public class Code39Part {
    private Nature nature;
    private int epaisseur;


    public Code39Part( int value, int indice) {
        this.epaisseur = ((value==0)?Epaisseur.ETROIT:Epaisseur.LARGE);
        if(indice%2==1) this.nature= Nature.BARRE;
        else this.nature = Nature.ESPACE;
    }


    public Nature getNature() {
        return nature;
    }

    public int getEpaisseur() {
        return epaisseur;
    }


}
