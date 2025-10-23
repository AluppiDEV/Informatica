import java.util.ArrayList;

public class Zona {

    private String nomeZona;
    private ArrayList<Animale> animaliPresenti;
    private static int MAX_CAPIENZA = 10;

    public Zona(String nomeZona) {
        this.nomeZona = nomeZona;
        this.animaliPresenti = new ArrayList<>();
    }

    public String aggiungiAnimale(Animale a) {
        if (animaliPresenti.size() < MAX_CAPIENZA) {
            animaliPresenti.add(a);
            return "Animale aggiunto alla zona " + nomeZona + "!\n";
        } else {
            return "Capienza massima raggiunta!\n";
        }
    }

    public String stampaDettagliZona() {
        StringBuilder str = new StringBuilder();
        str.append("Nome zona: " + nomeZona + "\n");
        if (animaliPresenti.isEmpty()) {
            str.append("\nNessun animale presente!\n");
        } else {
            for (Animale a : animaliPresenti) {
                str.append("\n " + a);
            }
        }
        return str.toString();
    }
}
