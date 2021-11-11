
import pokemons.*;
import ru.ifmo.se.pokemon.*;

public class lab2 {
    public static void main(String[] args) {
        Battle b = new Battle();
        Anorith p1 = new Anorith("amogus", 3);
        Armaldo p2 = new Armaldo("kito", 3);
        Bayleef p3 = new Bayleef("bob", 2);
        Chikorita p4 = new Chikorita("Victor", 1);
        Delibird p5 = new Delibird("Evgeniy", 2);
        Meganium p6 = new Meganium("Anton", 2);
        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);
        b.addFoe(p4);
        b.addFoe(p5);
        b.addFoe(p6);
        b.go();
    }
}
