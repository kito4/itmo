package moves;

import ru.ifmo.se.pokemon.*;

public class Blizzard extends SpecialMove {
    public Blizzard() {
        super(Type.ICE, 70, 110);
    }

    @Override
    protected boolean checkAccuracy(Pokemon att, Pokemon def) {
        return true;
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() < 0.1)
            Effect.freeze(p);
    }

    @Override
    protected String describe() {
        return "замораживает";
    }
}
