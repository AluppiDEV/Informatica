package Java.Domotica;

public class Termostato extends DispositivoRegolabile {

    public Termostato(String id) {
        this.id = id;
    }

    @Override
    public void accendi() {
        stato = true;
    }

    @Override
    public void spegni() {
        stato = false;
    }

    @Override
    public void impostaLivello(int livello) {
        this.livello = livello;
    }

    @Override
    public String generaRapportoStato() {
        return "Termostato [" + id + "] " + (stato ? "Acceso" : "Spento") + " - Target " + livello + "°C";
    }
}
