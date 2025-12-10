package Java.Gestione_aeroportuale;

import java.util.Random;

public class GestoreMeteo {
    private CondMeteo condizioneCorrente;
    private Random random;

    public GestoreMeteo() {
        this.random = new Random();
        this.condizioneCorrente = CondMeteo.SERENO;
    }

    public void aggiornaMeteo() {
        int scelta = random.nextInt(4);
        this.condizioneCorrente = CondMeteo.values()[scelta];
    }

    public CondMeteo getCondizioneCorrente() {
        return condizioneCorrente;
    }
}
