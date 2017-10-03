package logiciel_ascenseur.console;

import java.util.Scanner;

//will we responsible for display on 0
public class Display {
    public static void print(String s){
        System.out.println(s);
    }

    public static int getInt() {
        int res = -1;
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()) res = sc.nextInt();
        return res;
    }
}
