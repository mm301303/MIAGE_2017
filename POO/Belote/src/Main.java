import cards.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CardTool cardTool = new CardTool();
        ArrayList<CardInterface> cards = cardTool.initDeck();
        //connaître la valeur d'une carte selon qu'elle soit à l'atout ou non;

        for(CardInterface c : cards){
            System.out.println("*\t"+ c.getCardName() +" "+ c.getColor() + " -> valeur non atout : " + c.getValue());
            System.out.println(" \t -> valeur atout : " + c.getValue(c.getColor()));
        }

        //étant données quatre cartes, on veut savoir quelle est la carte la plus forte?
        System.out.println("min :"+ cardTool.compareCards(cards).getCardName());
        //étant données quatre cartes, on veut savoir quelle est la carte la plus forte,
        //en fonction de l'atout?
        System.out.println("min :"+ cardTool.compareCards(cards, CardColor.TREFLE).getCardName());

    }
}
