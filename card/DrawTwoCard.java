package card;

public class DrawTwoCard extends EffectCard {
    @Override
    protected int compareToCard(Card otherCard) {
        if (otherCard instanceof DrawTwoCard || getColor().equals(otherCard.getColor())) {
            return 0;
        }
        return -1;
    }

    DrawTwoCard(Color color, int value) {
        super(color,value);
    }

    @Override
    public String getDisplayName() {
        return "DrawTwoCard";
    }



    public String getType() {
        return  "DRAW_TWO";
    }

    @Override
    public String toString() {
        return getType()+ "(" + getColor() + ")";
    }
}