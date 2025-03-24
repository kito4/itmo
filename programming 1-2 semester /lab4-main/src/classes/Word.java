package classes;

public class Word {
    private String text;
    private int lenght;

    public Word(String str) {
        this.text = str;
        this.lenght = str.length();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }
}
