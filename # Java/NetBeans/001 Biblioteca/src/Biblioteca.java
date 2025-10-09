public class Biblioteca {
    private int bookNumber;
    private Libro[] books;

    public Biblioteca(int dim) {
        books = new Libro[Math.max(0, dim)];
        bookNumber = 0;
    }

    private int getBookNumber() {
        return bookNumber;
    }

    private void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public void addBook(Libro book) {
        books[getBookNumber()] = book;
        bookNumber++;
    }

    public String printAll() {
        String output = "";
        for (int i = 0; i < bookNumber; i++) {
            output += books[i].printDetails();
        }
        return output;
    }

}
