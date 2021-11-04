package moves;

import ru.ifmo.se.pokemon.*;

public class RockPolish extends StatusMove {
    public RockPolish() {
        super(Type.ROCK, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        Effect e1 = new Effect().turns(0).stat(Stat.SPEED, 2);

        p.addEffect(e1);

    }

    @Override
    protected String describe() {
        return "использует Rock Polish";
    }
}
