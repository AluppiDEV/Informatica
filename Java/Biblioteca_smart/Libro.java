package Java.Biblioteca_smart;

public class Libro {
    private String title;
    private String author;
    private float price;

    public Libro(String title, String author, float price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Libro() {
        title = "Nessun titolo";
        author = "Nessun autore";
        price = 0;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return "Titolo: " + title + " \t| Autore: " + author + " \t| Prezzo: " + price + "\n";
    }

    public float sconto(float percentuale) {
        return price * (1 - percentuale / 100);
    }
}
