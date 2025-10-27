import java.util.ArrayList;

public class Flotta {

    private static int idCounter = 1;
    private final int id;
    private ArrayList<Veicolo> veicoli;

    public Flotta() {
        this.id = idCounter;
        idCounter++;
        veicoli = new ArrayList<>();
    }

    public Flotta(Flotta f) {
        this.id = idCounter;
        idCounter++;
        this.veicoli = new ArrayList<>();
        this.veicoli.addAll(f.getVeicoli());
    }

    public String reportManutenzioneGenerale() {
        StringBuilder str = new StringBuilder();
        for (Veicolo v : veicoli) {
            str.append("\n Vicolo targato: " + v.getTarga()).append("\n");
            str.append("---------------------------");
            str.append(v.checkCarburante());
            str.append("---------------------------");
            str.append(v.checkManutenzione());
        }
        return str.toString();
    }

    public int getId() {
        return id;
    }

    public ArrayList<Veicolo> getVeicoli() {
        return veicoli;
    }

}