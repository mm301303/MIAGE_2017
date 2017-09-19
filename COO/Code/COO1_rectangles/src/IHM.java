import java.util.Scanner;

/**
 * HM : contient main() et les saisies/resultats
 */

public class IHM {
    static Rectangle rectangle;
    public static void main(String[] args) {

        System.out.println("Salut, ");
        System.out.println("J'espère que ça va bien ");
        System.out.println("Ici on fait des rectangles. Alors, ça te branche ?(Y/n)");
        String yesno= "Y";
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextLine()){
            yesno=sc.nextLine();
        }
        if(yesno.contains("y")||yesno.contains("Y"))
            createRectangle();

        System.out.println("Tu veux en faire un autre ?(Y/n)");
        sc = new Scanner(System.in);
        if(sc.hasNextLine()) {
            yesno = sc.nextLine();
        }
        if(yesno.contains("y")||yesno.contains("Y"))
            createRectangle();

        while(true){
            askWhatToDo();
        }

    }

    private static void askWhatToDo() {
        System.out.println("Tu veux les longeurs ? ?(Y/n)");
        String yesno=new String();
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextLine()) {
            yesno = sc.nextLine();
        }
        if(yesno.contains("y")||yesno.contains("Y"))
            givel();

        System.out.println("Tu veux les largeurs ? ?(Y/n)");
        yesno=new String();
        sc = new Scanner(System.in);
        if(sc.hasNextLine()) {
            yesno = sc.nextLine();
        }
        if(yesno.contains("y")||yesno.contains("Y"))
            giveL();

        System.out.println("Tu veux changer les dimensions ? ?(Y/n)");
        yesno=new String();
        sc = new Scanner(System.in);
        if(sc.hasNextLine()) {
            yesno = sc.nextLine();
        }
        if(yesno.contains("y")||yesno.contains("Y"))
            changeValues();
        displayS();
        asktoquit();

    }

    private static void asktoquit() {
        System.out.println("Quitter ?(y/n)");
        String yesno=new String();
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextLine()) {
            yesno = sc.nextLine();
        }
        if(yesno.contains("y")||yesno.contains("Y"))
            System.exit(0);
    }

    private static void displayS() {
        for(Rectangle r : Rectangle.instances) {
            System.out.println(r.getName()+" S="+r.getS());
        }
    }

    private static void changeValues() {
        for(Rectangle r : Rectangle.instances) {
            setValueFor(r);

        }
    }

    private static void setValueFor(Rectangle r) {
        System.out.println("Nouvelles valeurs pour "+r.getName()+"? (y/n)");
        double numberl=1,  numberL=1;
        String yesno=new String();
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextLine()) {
            yesno = sc.nextLine();
        }
        if(yesno.contains("y")||yesno.contains("Y")) {
            System.out.println("l: ");
            sc = new Scanner(System.in);
            if (sc.hasNextDouble()) {
                numberl = sc.nextDouble();
            }
            System.out.println("L: ");
            sc = new Scanner(System.in);
            if (sc.hasNextDouble()) {
                numberL = sc.nextDouble();
            }
            r.setl(numberl);
            r.setL(numberL);
            System.out.println("nouvelle surface pour " + r.getName() + " S=" + r.getS());
        }
    }

    private static void giveL() {
        for(Rectangle r : Rectangle.instances){
            System.out.println(r.getName()+ "L="+r.getL() );
        }
    }

    private static void givel() {
        if(rectangle.instances!=null) {
            for (Rectangle r : Rectangle.instances) {
                if(r!=null)
                System.out.println(r.getName() + "l=" + r.getl());
            }
        }
    }

    private static void createRectangle() {
        double numberl=0., numberL=0.;
        Rectangle rect;
        System.out.println("l: ");
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextDouble()) {
            numberl = sc.nextDouble();
        }
        System.out.println("L: ");
        sc = new Scanner(System.in);
        if(sc.hasNextDouble()) {
            numberL = sc.nextDouble();
        }

        rect = new Rectangle(numberl,numberL);

    }

}
