package classes;

public class Song {
    public String text;

    public Song(String text) {
        if ((text == null)) {
            throw new IllegalArgumentException("arguments of f() are null");
        }
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
