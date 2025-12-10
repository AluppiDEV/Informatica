package Java.Gestione_ospedaliera;

public abstract class Dipendente {

    // Contatore statico per generare matricole univoche
    private static int contatoreMatricola = 1;
    private String matricola;
    private String nome;
    private String cognome;
    protected double stipendioBase;

    public Dipendente(String nome, String cognome, double stipendioBase) {
        // Genera automaticamente una matricola univoca
        this.matricola = ""+contatoreMatricola;
        this.nome = nome;
        this.cognome = cognome;
        this.stipendioBase = stipendioBase;
        contatoreMatricola++;
    }

    public String getMatricola() {
        return matricola;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public double getStipendioBase() {
        return stipendioBase;
    }

    public void setStipendioBase(double stipendioBase) {
        this.stipendioBase = stipendioBase;
    }

    // Metodo astratto
    public abstract double calcolaStipendioMensile();

    public String stampaDati() {
        return "Matricola: " + matricola +
                ", Nome: " + nome +
                ", Cognome: " + cognome +
                ", Stipendio Base: " + stipendioBase;
    }
}
