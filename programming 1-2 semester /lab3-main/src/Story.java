import enums.Mood;
import classes.*;

import java.util.ArrayList;


public class Story {
    public static void main(String[] args) {
        Thing bell = new Thing("колокольчик");
        Thing lace = new Thing("шнурок");
        ArrayList<Thing> fav = new ArrayList<>();
        fav.add(lace);
        Thing announcement = new Thing("объявление");
        Background home = new Background("Дом");
        Background outside = new Background("улица");
        Background forest = new Background("Лес");
        Personage Fluff = new Personage("Пух", home, Mood.NORMAL);
        Personage Owl = new Personage("Сова", home, Mood.NORMAL);
        Personage Ia = new Personage("Иа", forest, Mood.SAD);
        Ia.setFavorite_things(fav);
        Dialog.AskaboutSomething(Fluff, Owl, false);
        Dialog.AskaboutSomething(Fluff, Owl, true);
        Fluff.changeLocation(outside);
        Owl.changeLocation(outside);
        Fluff.look(bell);
        Fluff.look(announcement);
        Fluff.look(lace);
        Fluff.take(lace);
        Fluff.changeLocation(forest);
        Fluff.give(lace, Ia);
        Fluff.setMood(Mood.HAPPY);

    }
}
