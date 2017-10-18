package cards;

public class CardImplementation implements CardInterface {

    private CardValue value;
    private CardColor color;

    public CardImplementation(CardColor c, CardValue v) {
        this.value = v;
        this.color = c;
    }

    @Override
    public int getValue() {
            return CardValue.nonAtoutValues[value.ordinal()];
    }

    @Override
    public CardValue getCardName() {
        return value;
    }

    @Override
    public int getValue(CardColor atout) {
        if(color.equals(atout))//meme instance
        {//atout
            return CardValue.atoutValues[value.ordinal()];

        }else{
            return getValue();
        }
    }

    @Override
    public CardColor getColor() {
        return this.color;
    }

    @Override
    public int compareTo(CardInterface c) {
        return (this.getValue()-c.getValue());
    }

    @Override
    public int compareTo(CardInterface c, CardColor atout) {
        if(this.color.ordinal()==atout.ordinal() && c.getColor().ordinal()!=atout.ordinal()){
            return 1;
        }else if(c.getColor().ordinal()==atout.ordinal()&&this.color.ordinal()!=atout.ordinal()){
            return -1;
        }else if(c.getColor().ordinal()==color.ordinal() && color.ordinal()==atout.ordinal()){
            return CardValue.atoutValues[value.ordinal()]-CardValue.atoutValues[c.getCardName().ordinal()];
        }
        return compareTo(c);

    }
}
