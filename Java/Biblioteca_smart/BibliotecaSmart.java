package Java.Biblioteca_smart;

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

    public void rimuoviElemento(int index) {
        libri.remove(index);
    }

    public void rimuoviDaTitolo(String title) {
        int index = 0;
        for (Libro l : libri) {
            if (l.getTitle().equals(title)) {
                index = libri.indexOf(l);
            }
        }
        libri.remove(index);
    }

}
