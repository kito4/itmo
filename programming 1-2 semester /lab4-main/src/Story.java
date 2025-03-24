import enums.Mood;
import classes.*;
import interfaces.Dialog;
import Exception.*;

import java.util.ArrayList;
import java.util.List;


public class Story {

    public static void main(String[] args) {
        Thing bell = new Thing("колокольчик");
        Thing lace = new Thing("шнурок");
        List<Thing> fav = new ArrayList<>();
        List<Song> fluff_song = new ArrayList<>();
        List<Song> robin_song = new ArrayList<>();
        List<Song> owl_song = new ArrayList<>();
        List<Task> robin_task = new ArrayList<>();
        fav.add(lace);
        Background.Weather.status = "Солнечно";
        Task obv = new Task("объявление");
        robin_task.add(obv);
        fluff_song.add(new Song("Кто нашел хвост?"));
        Thing announcement = new Thing("объявление");
        Background home = new Background("Дом");
        Background outside = new Background("улица");
        Background forest = new Background("Лес");
        Background.Weather story = new Background.Weather("Солнечно");
        Personage Fluff = new Personage("Пух", home, Mood.NORMAL);
        Personage Robin = new Personage("Кристофер Робин", forest, Mood.NORMAL);
        Personage.Mind fluff_mind = Fluff.new Mind(fluff_song);
        Personage Owl = new Personage("Сова", home, Mood.NORMAL);
        Personage Ia = new Personage("Иа", forest, Mood.SAD);
        Ia.setFavorite_things(fav);
        Personage.Mind robin_mind = Robin.new Mind(robin_song);
        Personage.Mind Owl_mind = Owl.new Mind(owl_song);
        robin_mind.setTasks(robin_task);
        List<Word> owl_words = new ArrayList<>();
        owl_words.add(new Word("wfwq"));
        owl_words.add(new Word("kjnvr"));
        owl_words.add(new Word("kjfnvwrn"));
        owl_words.add(new Word("anveoewinv"));
        owl_words.add(new Word("jsnvnsvnsdnvsdnv"));
        Owl.monolog(Fluff, owl_words);
        fluff_mind.say_about_Inventary();
        Dialog fluff = new Dialog() { //анонимный класс
            @Override
            public void remind_about_robin() {
                System.out.println("Сова объясняет Пуху об " + robin_mind.getTasks().get(0).getName());
            }

            @Override
            public void AskaboutSomething(Boolean x, Boolean lasttime) {
                if ((x == null) || (lasttime == null)) {
                    throw new IllegalArgumentException("arguments of f() are null");
                }
                if (lasttime) {
                    System.out.println("Нет, нет, никогда!");
                } else {
                    if (x) {
                        System.out.println("Софа спросила,пух ответил да");
                    } else {
                        System.out.println("Софа спросила,пух ответил нет");
                    }
                }
            }
        };
        fluff.AskaboutSomething(true, false);
        fluff.AskaboutSomething(false, false);
        fluff.AskaboutSomething(true, true);
        fluff.remind_about_robin();
        robin_mind.doTask(robin_mind.getTasks());
        try {
            Fluff.changeLocation(outside);
            Owl.changeLocation(outside);
        } catch (BadWeatherException e) {
            System.out.println("Нужно одеваться по погоде");
        }

        Fluff.look(bell);
        Fluff.look(announcement);
        try {
            Fluff.look(lace);
        } catch (DejavuException e) {
            System.out.println("Пух что-то понял");
        }
        Fluff.take(lace);
        try {
            Fluff.changeLocation(forest);
        } catch (BadWeatherException e) {
            System.out.println("Нужно одеваться по погоде");
        }
        Fluff.give(lace, Ia);
        Fluff.setMood(Mood.HUNGRY);

        try {
            Fluff.changeLocation(home);
        } catch (BadWeatherException e) {
            System.out.println("Нужно одеваться по погоде");
        }
        Fluff.eat(false);
        System.out.println("вытирает губы");

        fluff_mind.sing(0);
    }
}
