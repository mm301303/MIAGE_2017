public class Somme {
    public static void main(String[] args) {
        System.out.println("Salut, je somme mes arguments : ");
        int res = 0;
        for(String s : args){
            System.out.println(" + "+s);
            res += Integer.parseInt(s);
        }
        System.out.println(" = "+res);
    }
}
