package cards;

import java.util.ArrayList;
import java.util.List;

public class CardTool {

    public CardTool() {
    }

    public CardInterface compareCards(List<CardInterface> card) {
        return compareCards(card, CardColor.PIQUE, false);
    }


    public CardInterface compareCards(List<CardInterface> card, CardColor atout) {
        return compareCards(card, atout, true);
    }

    public CardInterface compareCards(List<CardInterface> card, CardColor atout, boolean considerAtout) {
        CardImplementation cardMin = (CardImplementation) card.get(0);
        for(int i=0; i<card.size(); i++){
            if(considerAtout && cardMin.compareTo(card.get(i), atout)>0){
                cardMin = (CardImplementation) card.get(i);
            }else if(!considerAtout && cardMin.compareTo(card.get(i))>0){
                cardMin = (CardImplementation) card.get(i);
            }
        }
        return cardMin;
    }

    public ArrayList<CardInterface> initDeck(){
        ArrayList<CardInterface> cards = new ArrayList<>();
        for(CardColor c : CardColor.values()){
            for(CardValue v : CardValue.values()){
                cards.add(new CardImplementation(c, v));
            }
        }
        return cards;
    }
}
