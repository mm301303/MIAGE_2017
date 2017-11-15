package exo1;

import org.alphabet.alphabets.Code39;

import java.util.Scanner;

public class Main {

    public static void main() {
        String str="null";
        System.out.println("please type a string of less than 9 chars");
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext()) str = sc.nextLine();
        System.out.println("you typed "+ str);
        CodeBar codeBar = new CodeBar(str);
        System.out.println("res : ["+codeBar.getAsciiArt()+"]");
    }
}
