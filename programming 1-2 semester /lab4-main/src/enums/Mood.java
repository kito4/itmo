package enums;

public enum Mood {
    HAPPY("радостное"),
    SAD("грустное"),
    NORMAL("нормальное"),
    ANRGY("злое"),
    HUNGRY("голоден"),
    FULL("ПОЕЛ") {},
    BORED("Скучает");


    private final String representation;

    Mood(String representation) {
        if ((representation == null)) {
            throw new IllegalArgumentException("arguments of f() are null");
        }
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }


    @Override
    public String toString() {
        return "Mood{" +
                "representation='" + representation + '\'' +
                '}';
    }
}

