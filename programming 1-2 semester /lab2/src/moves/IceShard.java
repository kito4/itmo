package moves;

import ru.ifmo.se.pokemon.*;

public class IceShard extends PhysicalMove {
    public IceShard() {
        super(Type.ICE, 40, 100);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.SPECIAL_ATTACK, 4);
    }

    @Override
    protected String describe() {
        return "использует Ice Shard";
    }
}
