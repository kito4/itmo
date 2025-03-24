package pokemons;

import moves.*;
import ru.ifmo.se.pokemon.*;

public class Bayleef extends Chikorita {
    public Bayleef(String name, int level) {
        super(name, level);
        setStats(55, 75, 50, 40, 40, 80);
        setType(Type.GRASS);
        addMove(new WorkUp());
    }
}
