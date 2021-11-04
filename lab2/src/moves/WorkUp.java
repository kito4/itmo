package moves;
import ru.ifmo.se.pokemon.*;

public class WorkUp extends StatusMove {
    public WorkUp() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected String describe() {
        return super.describe() + " [ Power: " + this.power + ", " + "Accuracy: " +
                this.accuracy + ", " + "Type: " + this.type + " ] ";
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        super.applySelfEffects(pokemon);
        pokemon.setMod(Stat.ATTACK, +1);
        pokemon.setMod(Stat.SPECIAL_ATTACK, +1);
    }
}
