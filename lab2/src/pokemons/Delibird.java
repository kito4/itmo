package pokemons;

import moves.*;
import ru.ifmo.se.pokemon.*;

public class Delibird extends Pokemon {
    public Delibird(String name, int level) {
        super(name, level);
        setStats(45, 55, 45, 65, 45, 75);
        setType(Type.ICE, Type.FLYING);
        setMove(new IceShard(), new HydroPump(), new Waterfall(), new Confide());
    }
}
