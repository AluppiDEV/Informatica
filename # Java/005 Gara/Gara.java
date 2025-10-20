import java.util.ArrayList;

public class Gara {
    
    private ArrayList<Atleta> partecipanti;

    public Gara() {
        partecipanti = new ArrayList<>();
    }

    public void aggiungiAtleta(Atleta a) {
        partecipanti.add(a);
    }

    public String stampaClassifica() {
        partecipanti.sort((a1, a2) -> Double.compare(a1.getTempoGara(), a2.getTempoGara()));
        String classifica = "";
        for (Atleta a : partecipanti) {
            classifica += (partecipanti.indexOf(a) + 1) + ". " + a.toString() + "\n";
        }
        return classifica;
    }

    public String cercaPerDiscip1ina(String disciplina) {
        String sb = "";
        for (Atleta a : partecipanti) {
            String d = a.getDisciplina();
            if (d != null && d.equalsIgnoreCase(disciplina)) {
                sb += a.toString() + "\n";
            }
        }
        return sb;
    }

}
