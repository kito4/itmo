package pokemons;

import moves.*;
import ru.ifmo.se.pokemon.*;

public class Armaldo extends Anorith {
    public Armaldo(String name, int level) {
        super(name, level);
        setStats(75, 125, 100, 70, 80, 45);
        setType(Type.ROCK, Type.BUG);
        addMove(new Blizzard());
    }
}
