package card;

public class SkipCard extends EffectCard  {
    @Override
    protected int compareToCard(Card otherCard) {
        if (otherCard instanceof SkipCard || getColor().equals(otherCard.getColor())) {
            return 0;
        }
        return -1;
    }
    SkipCard(Color color, int value) {
        super(color,value);
    }
    public String getDisplayName() {
        return "SkipCard";
    }
    @Override
    public String getType() {
        return  "SKIP";
    }
    @Override
    public String toString() {
        return "Skip Card (" + getColor() + ")";
    }
}