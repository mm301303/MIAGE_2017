import cards.CardColor;
import cards.CardImplementation;
import cards.CardInterface;
import cards.CardValue;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<CardInterface> cards = initDeck();

        //connaître la valeur d'une carte selon qu'elle soit à l'atout ou non;

        for(CardInterface c : cards){
            System.out.println("*\t"+ c.getCardName() +" "+ c.getColor() + " -> valeur non atout : " + c.getValue());
            System.out.println(" \t -> valeur non atout : " + c.getValue(c.getColor()));
        }

        //étant données quatre cartes, on veut savoir quelle est la carte la plus forte?
        CardInterface[] cardsToCompare = new CardImplementation[4];
        int i = 0;
        for(CardInterface c1 : cards){
            i++;
            for(CardInterface c2 : cards) {
                i++;
                //TODO finish this
                if(i==3) cardsToCompare = new CardImplementation[4];
            }
        }

        //étant données quatre cartes, on veut savoir quelle est la carte la plus forte,
        //en fonction de l'atout?
    }

    private static ArrayList<CardInterface> initDeck(){
        ArrayList<CardInterface> cards = new ArrayList<>();
        for(CardColor c : CardColor.values()){
            for(CardValue v : CardValue.values()){
                cards.add(new CardImplementation(c, v));
            }
        }
        return cards;
    }

    private CardInterface getStrongerCard(ArrayList<CardInterface> cards){
        CardInterface min = cards.get(0);
        int min_value = min.getValue();
        for(CardInterface c : cards){
            if(c.compareTo(min)<0){
                min = c;
                min_value = c.getValue();
            }
        }
        return min;
    }
}
