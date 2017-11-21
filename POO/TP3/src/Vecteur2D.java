/*
Un Vecteur2D v est un objet qui a deux composantes v=< x, y >.
On sait lire la valeur de chacune des deux composantes x et y
On NE sait PAS modifier les valeurs des composantes d'un vecteur
 */

public class Vecteur2D {
    private int x;
    private int y;


    public Vecteur2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vecteur2D multiply(int k){
        return new Vecteur2D(this.x*k, this.y*k);
    }

    public Vecteur2D add(Vecteur2D v){
        return new Vecteur2D(v.getX()+x, v.getY()+y);
    }

    public Vecteur2D scalarProduct(Vecteur2D v){
       return new Vecteur2D(v.getX()*this.x, v.getY()*this.y);
    }

    public void transpose(){
        int temp = this.x;
        this.x = this.y;
        this.y = temp;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString(){
        return "V = < "+this.x+" ; "+this.y+" >";
    }
}
