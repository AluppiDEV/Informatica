package Java.Flotta_spaziale;

public class IncrociatoreDaBattaglia extends NaveSpaziale {

    private int potenzaScudi;
    private int numeroCannoniLaser;

    public IncrociatoreDaBattaglia(String idRegistrazione, double capacitaMassima, StatoNave stato, int potenzaScudi, int numeroCannoniLaser) {
        super(idRegistrazione, capacitaMassima, stato);
        this.potenzaScudi = potenzaScudi;
        this.numeroCannoniLaser = numeroCannoniLaser;
    }

    @Override
    public boolean requisitiSicurezzaSoddisfatti(Missione m) {
        if (potenzaScudi < m.getPesoTotale()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public double calcolaCostoOperativo(Missione m) {
        return 5000 + (10 * m.getPesoTotale() * 1.5);
    }
}
