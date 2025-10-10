public class Libro {
    private String title;
    private String author;
    private float price;

    public Libro(String title, String author, float price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    private String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private String getAuthor() {
        return author;
    }

    private void setAuthor(String author) {
        this.author = author;
    }

    private float getPrice() {
        return price;
    }

    private void setPrice(float price) {
        this.price = price;
    }

    public String printDetails() {
        return "Titolo: " + getTitle() + " Autore: " + getAuthor() + " Prezzo: " + getPrice() + "\n";
    }

    public double sconto(double percentuale) {
        return getPrice() * (1 - percentuale / 100);
    }

}
