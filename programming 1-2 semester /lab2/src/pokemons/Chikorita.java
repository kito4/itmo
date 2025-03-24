package pokemons;

import moves.*;
import ru.ifmo.se.pokemon.*;

public class Chikorita extends Pokemon {
    public Chikorita(String name, int level) {
        super(name, level);
        setStats(40, 55, 30, 30, 30, 60);
        setType(Type.NORMAL, Type.FLYING);
        setMove(new Facade(), new DoubleTeam());
    }
}
