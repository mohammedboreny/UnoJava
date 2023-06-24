package card;

public abstract class EffectCard extends Card  {
    public EffectCard(Color color,int value) {
        super(color, value);
    }
    public abstract String getType();

}
