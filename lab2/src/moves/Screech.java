package moves;

import ru.ifmo.se.pokemon.*;

public class Screech extends StatusMove {
    public Screech() {
        super(Type.NORMAL, 18, 80);
    }

    @Override
    protected String describe() {
        return "наносит яростные удары";
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.DEFENSE, 2);
    }
}