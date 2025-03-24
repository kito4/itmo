package moves;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class SignalBeam extends SpecialMove {
    public SignalBeam() {
        super(Type.BUG, 75, 100);
    }

    @Override
    protected boolean checkAccuracy(Pokemon att, Pokemon def) {
        return true;
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() < 0.1)
            Effect.confuse(p);
    }

    @Override
    protected String describe() {
        return "замораживает";
    }
}

