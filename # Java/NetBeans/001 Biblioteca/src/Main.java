//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Biblioteca library = new Biblioteca(5);
        Libro book1 = new Libro("Le mie cazzate", "Russo", 2);
        library.addBook(book1);
        library.addBook(new Libro("Quanto sono inteligente", "AA.VV", 5));
        library.addBook(new Libro("In cucina con tonypitony", "Tonypitony", 10));
        library.addBook(new Libro("In cucina con tonypitony", "Tonypitony", 10));
        library.addBook(new Libro("In cucina con tonypitony", "Tonypitony", 10));

        System.out.println(library.printAll());
    }
}