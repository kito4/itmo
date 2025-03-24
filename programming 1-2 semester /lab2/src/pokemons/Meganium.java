package pokemons;

import moves.*;
import ru.ifmo.se.pokemon.*;

public class Meganium extends Bayleef {
    public Meganium(String name, int level) {
        super(name, level);
        setStats(85, 120, 70, 50, 60, 100);
        setType(Type.NORMAL, Type.FLYING);
        addMove(new SignalBeam());
    }
}
