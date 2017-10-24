package cards;

public interface CardInterface {

    //connaître la valeur d'une carte selon qu'elle soit à l'atout ou non;
    CardValue getCardName();
    int getValue(CardColor atout);
    int getValue();
    CardColor getColor();
    //étant données quatre cartes, on veut savoir quelle est la carte la plus forte?
    int compareTo(CardInterface c);
    //étant données quatre cartes, on veut savoir quelle est la carte la plus forte,
    //en fonction de l'atout?
    int compareTo(CardInterface c, CardColor atout);


}
