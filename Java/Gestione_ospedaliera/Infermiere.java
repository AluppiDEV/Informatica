package Java.Gestione_ospedaliera;

public class Infermiere extends Dipendente {

    private String reparto;
    private int turniNotturni;

    public Infermiere(String nome, String cognome, double stipendioBase,
                      String reparto, int turniNotturni) {
        super(nome, cognome, stipendioBase);
        this.reparto = reparto;
        this.turniNotturni = turniNotturni;
    }

    @Override
    public double calcolaStipendioMensile() {
        return stipendioBase + (80 * turniNotturni);
    }

    @Override
    public String stampaDati() {
        return super.stampaDati() +
                ", Reparto: " + reparto +
                ", Turni notturni: " + turniNotturni +
                ", Stipendio Mensile: " + calcolaStipendioMensile();
    }
}
