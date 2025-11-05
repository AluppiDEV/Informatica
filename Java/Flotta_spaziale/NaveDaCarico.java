package Java.Flotta_spaziale;

public class NaveDaCarico extends NaveSpaziale {

    private boolean stivaSchermata;

    public NaveDaCarico(String idRegistrazione, double capacitaMassima, StatoNave stato, boolean stivaSchermata) {
        super(idRegistrazione, capacitaMassima, stato);
        stivaSchermata = stivaSchermata;
    }

    @Override
    public boolean requisitiSicurezzaSoddisfatti(Missione m) {
        if (m.getLivelloPericoloSettore() > 5) {
            return false;
        } else if (m.isMissionePericolosa() && !stivaSchermata) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public double calcolaCostoOperativo(Missione m) {
        return 10 * m.getPesoTotale();
    }
}
