package classes;

import interfaces.ThingInterface;

import java.util.Objects;

public class Thing implements ThingInterface {
    protected String name;

    @Override
    public String getName() {
        return name;
    }

    public Thing(String name) {
        this.name = name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thing thing = (Thing) o;
        return Objects.equals(name, thing.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
