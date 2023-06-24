package card;

public class WildDrawFourCard extends EffectCard {
    WildDrawFourCard(Color color, int value) {
        super(color, value);
    }
    @Override
    public String getDisplayName() {
        return "WildDrawFourCard";
    }
    @Override
    public String getType() {
        return  "DRAW_FOUR";
    }
    @Override
    public String toString() {
        if (color != Color.WILD) {
            return "Wild Draw Four Card (" + color.name() + ")";
        } else {
            return "Wild Draw Four Card (WILD)";
        }
    }
    public void setChosenColor(Color chosenColor) {
        this.color= chosenColor;
    }
    @Override
    protected int compareToCard(Card otherCard) {
        if (otherCard instanceof WildCard&&otherCard.color==Color.WILD)
            return 0;

        if (this.color == otherCard.getColor() ) {
            return 0;
        }
        return -1;
    }
}