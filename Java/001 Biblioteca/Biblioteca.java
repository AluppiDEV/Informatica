public class Biblioteca {
    private int bookNumber;
    private Libro[] books;

    public Biblioteca(int dim) {
        books = new Libro[Math.max(0, dim)];
        bookNumber = 0;
    }

    public void addBook(Libro book) {
        if (bookNumber >= books.length) {
            System.out.println("La biblioteca è piena, impossibile aggiungere altri libri.");
            return;
        }
        books[bookNumber++] = book;
    }

    public String printAll() {
        String output = "";
        for (Libro libro : books) {
            output += libro;
        }
        return output;
    }

    public String applicaSconto(int index, float percentuale) {
        if (index < 0 || index >= bookNumber || books[index] == null) {
            return "Errore";
        }
        return "Sconto sul libro " + books[index].getTitle() + " applicato, nuovo prezzo: "
                + books[index].sconto(percentuale);
    }
}
