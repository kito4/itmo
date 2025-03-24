package classes;

import java.util.Random;

import Exception.*;
import abstractions.Location;
import interfaces.Reaction;
import enums.Mood;
import interfaces.HasMood;
import interfaces.Mobile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Personage implements HasMood, Mobile, Reaction {
    List<Thing> favorite_things = new ArrayList<>();
    private final String name;
    private Location location;
    private Mood moodState;
    private List<Thing> inventary = new ArrayList<>();
    private Thing tale;

    public class Mind {
        List<Song> know_song = new ArrayList<>();
        List<Task> tasks = new ArrayList<>();

        public Mind(List<Song> know_song) {
            if ((know_song == null)) {
                throw new IllegalArgumentException("arguments of f() are null");
            }
            this.know_song = know_song;
        }

        public void say_about_Inventary() {
            System.out.println("У " + name + " " + inventary.size() + " вещей");
        }

        public void setTasks(List<Task> tasks) {
            this.tasks = tasks;
        }

        public List<Task> getTasks() {
            return tasks;
        }

        public void doTask(List task) {
            List<Task> empty = new ArrayList<>();
            this.setTasks(empty);
            System.out.println("Объявление создано");
        }

        public void sing(Integer i) {
            if ((i == null)) {
                throw new IllegalArgumentException("arguments of f() are null");
            }
            System.out.println("поет песню " + know_song.get(i).getText());
        }
    }

    public void monolog(Personage persona, List<Word> all_word) {
        for (Word text : all_word) {
            System.out.println("Сова сказала слово длиной " + text.getLenght());
        }
        persona.setMood(Mood.BORED);
    }

    public Personage(String name, Location location, Mood moodState) {
        if ((name == null) || (location == null) || (moodState == null)) {
            throw new IllegalArgumentException("arguments of f() are null");
        }
        this.name = name;
        this.location = location;
        this.moodState = moodState;
    }

    public void setFavorite_things(List<Thing> favorite_things) {
        if ((favorite_things == null)) {
            throw new IllegalArgumentException("arguments of f() are null");
        }
        this.favorite_things = favorite_things;
    }

    public String getName() {
        return name;
    }

    public void changeLocation(Background str1) throws BadWeatherException {
        if ((str1 == null)) {
            throw new IllegalArgumentException("arguments of f() are null");
        }
        if (Background.Weather.status.equals("Дождь")) {
            throw new BadWeatherException("Плохая погода");
        }
        location.name = str1.name;
        System.out.println(name + " переместился на " + location.name);
    }

    @Override
    public String getLocation() {
        return location.name;
    }

    @Override
    public String getMood() {
        return moodState.getRepresentation();
    }

    @Override
    public void setMood(Mood newMood) {
        if ((newMood == null)) {
            throw new IllegalArgumentException("arguments of f() are null");
        }
        moodState = newMood;
        System.out.println("У " + name + " теперь " + getMood() + " настроение");
    }

    public void setTale(Thing tale) {
        if ((tale == null)) {
            throw new IllegalArgumentException("arguments of f() are null");
        }
        this.tale = tale;
        System.out.println("Хвост прикреплен");
    }

    public void look(Thing thing) throws DejavuException {
        if ((thing == null)) {
            throw new IllegalArgumentException("arguments of f() are null");
        }
        System.out.println(name + " смотрит на " + thing.name);
        if (thing.name.equals("шнурок")) {
            throw new DejavuException("У Пуха дежавю");
        }
    }

    public void take(Thing thing) {
        if ((thing == null)) {
            throw new IllegalArgumentException("arguments of f() are null");
        }
        inventary.add(thing);
        System.out.println(name + " взял " + thing.name);
    }

    public void give(Thing thing, Personage receiver) {
        if ((thing == null) || (receiver == null)) {
            throw new IllegalArgumentException("arguments of f() are null");
        }
        inventary.remove(thing);
        receiver.inventary.add(thing);
        System.out.println(name + " отдал " + thing.name + " " + receiver.getName());
        react_to_thing(thing, receiver);
    }


    @Override
    public void react_to_thing(Thing thing, Personage persona) {
        if ((thing == null) || (persona == null)) {
            throw new IllegalArgumentException("arguments of f() are null");
        }
        if (persona.favorite_things.contains(thing)) {
            if (thing.name.equals("шнурок")) {
                persona.inventary.remove(thing);
                persona.setTale(thing);
                persona.setMood(Mood.HAPPY);
            }
        }

    }

    public void eat(Boolean carefully) {
        if ((carefully == null)) {
            throw new IllegalArgumentException("arguments of f() are null");
        }

        System.out.println("Пух ест мед");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personage personage = (Personage) o;
        return Objects.equals(favorite_things, personage.favorite_things) && Objects.equals(name, personage.name) && Objects.equals(location, personage.location) && moodState == personage.moodState && Objects.equals(inventary, personage.inventary) && Objects.equals(tale, personage.tale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(favorite_things, name, location, moodState, inventary, tale);
    }
}
