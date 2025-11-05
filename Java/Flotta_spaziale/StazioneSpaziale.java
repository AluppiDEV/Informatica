package Java.Flotta_spaziale;

import java.util.ArrayList;

public class StazioneSpaziale {

    private String nomeStazione;
    ArrayList<NaveSpaziale> flottaDisponibile;
    private ArrayList<Missione> missioniInAttesa;

    public StazioneSpaziale(String nomeStazione) {
        this.nomeStazione = nomeStazione;
        flottaDisponibile = new ArrayList<>();
        missioniInAttesa = new ArrayList<>();
    }

    public String getNomeStazione() {
        return nomeStazione;
    }

    public void aggiungiNaveAFlotta(NaveSpaziale n) {
        flottaDisponibile.add(n);
    }

    public void aggiungiMissione(Missione m) {
        missioniInAttesa.add(m);
    }

    public NaveSpaziale assegnaNaveOttimale(Missione missione) {
        double pesoTotale = missione.getPesoTotale();
        ArrayList<NaveSpaziale> naviCandidate = new ArrayList<>();

        for (NaveSpaziale n : flottaDisponibile) {
            if (n.getStato() == StatoNave.DISPONIBILE && n.puoTrasportare(pesoTotale) && n.requisitiSicurezzaSoddisfatti(missione)) {
                naviCandidate.add(n);
            }
        }

        if (naviCandidate.isEmpty()) {
            return null;
        } else {
            naviCandidate.sort((n1, n2) -> Double.compare(n1.calcolaCostoOperativo(missione), n2.calcolaCostoOperativo(missione)));
            flottaDisponibile.get(flottaDisponibile.indexOf(naviCandidate.get(0))).stato = StatoNave.IN_MISSIONE;
            missioniInAttesa.remove(missione);
            return naviCandidate.get(0);
        }
    }
}
