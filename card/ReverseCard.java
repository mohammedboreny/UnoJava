package card;

public class ReverseCard extends EffectCard{
    @Override
    protected int compareToCard(Card otherCard) {
        if (otherCard instanceof ReverseCard || getColor().equals(otherCard.getColor())) {
            return 0;
        }
        return -1;
    }
    ReverseCard(Color color, int value) {
        super(color,value);
    }
    @Override
    public String getDisplayName() {
        return "ReverseCard";
    }
    @Override
    public String toString() {
        return "Reverse Card (" + getColor() + ")";
    }
    @Override
    public String getType() {
        return "REVERSE";
    }

}