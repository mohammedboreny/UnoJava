package card;

public class WildCard extends EffectCard {
    WildCard(Color color, int value) {
        super(color, value);
    }
    @Override
    public String toString() {
        if (color != null && color != Color.WILD) {
            return "Wild Card (" + color.name() + ")";
        } else {
            return "Wild Card (WILD)";
        }
    }
    @Override
    public String getDisplayName() {
        return "WildCard";
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
    @Override
    public String getType() {
        return  "Wild";
    }
}