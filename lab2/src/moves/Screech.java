package moves;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class Screech extends StatusMove {
    public Screech() {
        super(Type.NORMAL, 18, 80);
    }

    @Override
    protected String describe() {
        return "наносит яростные удары";
    }
}