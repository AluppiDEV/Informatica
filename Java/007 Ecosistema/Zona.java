import java.util.ArrayList;

public class Zona {

    private String nome;
    private ArrayList<Animale> animali;
    private static final int MAX = 10;

    public Zona(String nome) {
        this.nome = nome;
        this.animali = new ArrayList<>();
    }

    public boolean aggiungiAnimale(Animale a) {
        if (animali.size() < MAX) {
            animali.add(a);
            return true;
        }
        return false;
    }

    public String stampaDettagliZona() {
        StringBuilder str = new StringBuilder();
        str.append("Nome zona: " + nome + "\n");
        if (animali.isEmpty()) {
            str.append("\nNessun animale presente!\n");
        } else {
            for (Animale a : animali) {
                str.append("\n " + a);
            }
        }
        return str.toString();
    }
}
