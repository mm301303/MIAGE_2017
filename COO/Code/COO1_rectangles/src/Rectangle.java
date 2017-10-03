/**
 * Rectangle : calcule sa surface, contient l et L, et un tableau statique d'instances de rectangle
 */

public class Rectangle {

    //c'est un cours de coo, ici le rectangle a pas vocation a etre représenté dans l'espace...

    protected static final int max_number=2;//on pourra en mettre plus en changeant ça (baaah)
    public static Rectangle instances[];
    protected static int indiceInstance=0;


    private double l;
    private double L;
    private double S;

    public String getName() {
        return name;
    }

    private String name;

    public Rectangle(double l, double L){
        if(instances==null){
            instances=new Rectangle[max_number];
            indiceInstance=0;
        }
        else if(indiceInstance<max_number-1) {
            indiceInstance++;   
        }
        this.l = Math.abs(l);
        this.L = Math.abs(L);
        this.S = computeS();
        
        this.name = "R" + indiceInstance;
        instances[indiceInstance]=this;

        //on gere pas les exception on a dit
    }

    private double computeS(){
        return l*L;
    }

    public double getS(){
        return S;
    }

    public double getl() {
        return l;
    }

    public double getL() {
        return L;
    }

    public void setl(double l) {
        this.l = l;
        S=computeS();
    }

    public void setL(double L) {
        this.L = L;
        S=computeS();
    }

}
