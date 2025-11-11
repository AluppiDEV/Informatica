package Java.Animali;

import java.util.ArrayList;

public class Zoo {

    private ArrayList<Animale> animali = new ArrayList<Animale>();

    public Zoo() {
        animali.add(new Coccodrillo());
        animali.add(new Zebra());
        animali.add(new Malavasi());
        animali.add(new Gatto());
    }

    public String nanna() {
        StringBuilder str = new StringBuilder();
        for (Animale a : animali) {
            str.append(a.dormi()).append("\n");
        }
        return str.toString();
    }

    public String concerto() {
        StringBuilder str = new StringBuilder();
        for (Animale a : animali) {
            str.append(a.verso()).append("\n");
        }
        return str.toString();
    }
}
