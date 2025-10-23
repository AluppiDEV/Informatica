public class Libro {
    private String title;
    private String author;
    private float price;

    public Libro(String title, String author, float price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return "Titolo: " + title + " | Autore: " + author + " | Prezzo: " + price + "\n";
    }

    public float sconto(float percentuale) {
        return price * (1 - percentuale / 100);
    }
}
