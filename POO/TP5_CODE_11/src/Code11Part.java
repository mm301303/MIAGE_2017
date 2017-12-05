//Représente un caractère à un emplacement d'un Code11Word
public class Code11Part {
    private Nature nature;
    private int epaisseur;


    public Code11Part(char value, int indice) {
        epaisseur=(value==Epaisseur.LARGE)? epaisseur=Epaisseur.LARGE : Epaisseur.ETROIT;
        this.nature= (indice%2==0)? this.nature= Nature.BARRE : Nature.ESPACE;//le premier est une barre
    }


    public Nature getNature() {
        return nature;
    }

    public int getEpaisseur() {
        return epaisseur;
    }


}
