package Java.Flotta_spaziale;

public abstract class NaveSpaziale {

    protected String idRegistrazione;
    protected double capacitaMassima;
    protected StatoNave stato;

    public NaveSpaziale(String idRegistrazione, double capacitaMassima, StatoNave stato) {
        this.idRegistrazione = idRegistrazione;
        this.capacitaMassima = capacitaMassima;
        this.stato = stato;
    }

    public String getIdRegistrazione() {
        return idRegistrazione;
    }

    public double getCapacitaMassima() {
        return capacitaMassima;
    }

    public StatoNave getStato() {
        return stato;
    }

    public void setStato(StatoNave nuovoStato) {
        this.stato = nuovoStato;
    }

    public boolean puoTrasportare(double pesoRichiesto) {
        if (pesoRichiesto <= capacitaMassima) {
            return true;
        }
        return false;
    }

    public abstract boolean requisitiSicurezzaSoddisfatti(Missione m);

    public abstract double calcolaCostoOperativo(Missione m);
}
