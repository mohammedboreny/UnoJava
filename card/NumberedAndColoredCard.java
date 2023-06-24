package card;

public class NumberedAndColoredCard extends Card  {
    private int number;

    public NumberedAndColoredCard(Color color, int value, int number) {
        super(color, value);
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    @Override
    public String getDisplayName() {
        return String.format("%s %d Card (%s)", color == Color.WILD ? "Wild" : color, number, color);
    }
    @Override
    protected int compareToCard(Card o) {
        if (o instanceof NumberedAndColoredCard otherNumberedCard) {
            // Compare based on color and number
            if (this.color == otherNumberedCard.color ) {
                return 0;
            }else if (this.number == otherNumberedCard.number){
                return 0;
            }
        }
        return -1;
    }


    @Override
    public String toString() {
        return "NumberedAndColoredCard{" +
                "number=" + number +
                ", color=" + color +
                '}';
    }

}