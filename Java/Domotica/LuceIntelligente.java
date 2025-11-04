package Java.Domotica;

public class LuceIntelligente extends DispositivoRegolabile {

    public LuceIntelligente(String id) {
        this.id = id;
    }

    @Override
    public void accendi() {
        stato = true;
        livello = 100;
    }

    @Override
    public void spegni() {
        stato = false;
        livello = 0;
    }

    @Override
    public void impostaLivello(int livello) {
        this.livello = livello;
    }

    @Override
    public String generaRapportoStato() {
        return "Luce [" + id + "] " + (stato ? "Acceso" : "Spento") + " - Luminosità " + livello + "%";
    }
}
