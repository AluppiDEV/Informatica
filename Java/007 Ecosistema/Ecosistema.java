import java.util.ArrayList;

public class Ecosistema {
    private String nomeEcosistema;
    private ArrayList<Zona> zone;

    public Ecosistema(String nomeEcosistema) {
        this.nomeEcosistema = nomeEcosistema;
        this.zone = new ArrayList<>();
    }

    public void aggiungiZona(Zona z) {
        this.zone.add(z);
    }

    public String mostraReportEcosistema() {
        StringBuilder str = new StringBuilder();
        str.append("REPORT ECOSISTMA: " + nomeEcosistema + "\n\n");
        for (Zona z : zone) {
            str.append(z.stampaDettagliZona());
            str.append("\n---------------------------\n");
        }
        return str.toString();
    }
}
