package classes;

import interfaces.ThingInterface;

import java.util.Objects;

public class Tale implements ThingInterface {
    protected String name;

    @Override
    public String getName() {
        return name;
    }

    public Tale(String name) {
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
        Tale tale = (Tale) o;
        return Objects.equals(name, tale.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}

