import java.util.ArrayList;

public class BibliotecaSmart {
    private ArrayList<Libro> libri;

    public BibliotecaSmart() {
        libri = new ArrayList<>();
    }

    public void aggiungiLibro(Libro l) {
        libri.add(l);
    }

    public String stampaTutti() {
        String out = "";

        for (Libro l : libri) {
            out += l;
        }

        return out;
    }

}
