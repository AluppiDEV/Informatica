package Java.Gestione_ospedaliera;

public class Medico extends Dipendente {

    private String specializzazione;
    private int numeroInterventi;

    public Medico(String nome, String cognome, double stipendioBase,
                  String specializzazione, int numeroInterventi) {
        super(nome, cognome, stipendioBase);
        this.specializzazione = specializzazione;
        this.numeroInterventi = numeroInterventi;
    }

    @Override
    public double calcolaStipendioMensile() {
        return stipendioBase + (50 * numeroInterventi);
    }

    @Override
    public String stampaDati() {
        return super.stampaDati() +
                ", Specializzazione: " + specializzazione +
                ", Interventi: " + numeroInterventi +
                ", Stipendio Mensile: " + calcolaStipendioMensile();
    }
}
