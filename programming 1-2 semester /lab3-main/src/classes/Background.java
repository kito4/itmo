package classes;

import abstractions.Location;

public class Background extends Location {
    public Background(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Background{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getLocation(Location p1) {
        return p1.name;
    }
}
