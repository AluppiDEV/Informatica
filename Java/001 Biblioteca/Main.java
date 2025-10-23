public class Main {
    public static void main(String[] args) {
        Biblioteca b = new Biblioteca(5);
        b.addBook(new Libro("Le mie cazzate", "Russo", 2));
        b.addBook(new Libro("Ceppa", "Gay", 5));
        b.addBook(new Libro("Russo", "fuma", 10));
        b.addBook(new Libro("Morgan", "palle", 15));
        b.addBook(new Libro("In cucina con Tonypitony 3", "Tonypitony", 20));

        System.out.println(b.printAll());

        for (int i = 0; i < 5; i++) {
            System.out.println(b.applicaSconto(i, 10));
        }
    }
}
