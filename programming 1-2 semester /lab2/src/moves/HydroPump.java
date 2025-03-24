package moves;

import ru.ifmo.se.pokemon.*;

public class HydroPump extends SpecialMove {
    public HydroPump() {
        super(Type.WATER, 80, 110);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.setMod(Stat.SPECIAL_ATTACK, -1);
    }

    @Override
    protected String describe() {
        return "использует Hydro Pump";
    }
}
