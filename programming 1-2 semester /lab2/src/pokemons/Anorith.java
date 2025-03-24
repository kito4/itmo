package pokemons;

import moves.*;
import ru.ifmo.se.pokemon.*;

public class Anorith extends Pokemon {
    public Anorith(String name, int level) {
        super(name, level);
        setStats(40, 40, 55, 40, 70, 55);
        setType(Type.ROCK, Type.BUG);
        setMove(new RockPolish(), new Facade(), new Screech());
    }
}
