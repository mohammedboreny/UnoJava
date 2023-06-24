package card;

public abstract class Card implements Comparable<Card> {
    protected Color color;
    protected int value;
    protected String type;

    public Card(Color color, int value) {
        this.color = color;
        this.value = value;
        this.type="";
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract String getDisplayName();

    @Override
    public String toString() {
        return getDisplayName();
    }

    public Color getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }
    public static Card createCard(String type, Color color, int value, int number) {
        switch (type.toUpperCase()) {
            case "NUMBERED":
                return new NumberedAndColoredCard(color, value, number);
            case "SKIP":
                return new SkipCard(color, value);
            case "REVERSE":
                return new ReverseCard(color, value);
            case "DRAW_TWO":
                return new DrawTwoCard(color, value);
            case "WILD":
                return new WildCard(color,value);
            case "WILD_DRAW_FOUR":
                return new WildDrawFourCard(color,value);
            default:
                throw new IllegalArgumentException("Invalid card type: " + type);
        }
    }
    @Override
    public int compareTo(Card otherCard) {
        return compareToCard(otherCard);
    }

    // Other methods...

    protected abstract int compareToCard(Card otherCard);
}
