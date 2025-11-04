package Java.Biblioteca_smart;

public class Main {
    public static void main(String[] args) {
        BibliotecaSmart bs = new BibliotecaSmart();

        bs.aggiungiLibro(new Libro("Le mie cazzate", "Russo", 2));
        bs.aggiungiLibro(new Libro("Ceppa", "Gay", 5));
        bs.aggiungiLibro(new Libro("Russo", "fuma", 10));
        bs.aggiungiLibro(new Libro("Morgan", "palle", 15));
        bs.aggiungiLibro(new Libro("In cucina con Tonypitony 3", "Tonypitony", 20));

        System.out.println(bs.stampaTutti());
        
        bs.rimuoviElemento(0);

        System.out.println(bs.stampaTutti());
        
        bs.rimuoviDaTitolo("Morgan");

        System.out.println(bs.stampaTutti());
    }
}
