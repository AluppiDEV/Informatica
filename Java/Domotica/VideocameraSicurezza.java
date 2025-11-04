package Java.Domotica;

public class VideocameraSicurezza extends Dispositivo {

    private boolean staRegistrando;

    public VideocameraSicurezza(String id, boolean staRegistrando) {
        this.staRegistrando = staRegistrando;
    }

    @Override
    public void accendi() {
        stato = true;
    }

    @Override
    public void spegni() {
        stato = false;
        staRegistrando = false;
    }

    @Override
    public String generaRapportoStato() {
        return "Termostato [" + id + "] " + (stato ? "Acceso" : "Spento") + " - " + (staRegistrando ? "In regstrazione" : "In pausa");
    }
}
