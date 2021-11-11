package moves;

import ru.ifmo.se.pokemon.*;

public class RockPolish extends StatusMove {
    public RockPolish() {
        super(Type.ROCK, 0, 0);
    }

    @Override
    public String describe() {
        return "use Rock Polish";
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.SPEED, 2);
    }
}