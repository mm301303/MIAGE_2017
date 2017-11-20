package exo1;


public class Code39Part {
    private Nature nature;
    private Epaisseur epaisseur;


    public Code39Part(int value, int indice){
        this((value==0)?Epaisseur.ETROIT:Epaisseur.LARGE,indice);
    }

    public Code39Part(Epaisseur epaisseur, int indice) {
        this.epaisseur = epaisseur;
        if(indice%2==1) this.nature= Nature.BARRE;
        else this.nature = Nature.ESPACE;
    }


    public Nature getNature() {
        return nature;
    }

    public Epaisseur getEpaisseur() {
        return epaisseur;
    }
}
