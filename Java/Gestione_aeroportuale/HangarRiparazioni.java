package Java.Gestione_aeroportuale;

public class HangarRiparazioni extends Infrastruttura {
    private int turniRimanenti;

    public HangarRiparazioni(String id) {
        super(id);
        this.turniRimanenti = 0;
    }

    public void iniziaRiparazione(Velivolo velivolo) {
        occupa(velivolo);
        this.turniRimanenti = 3;
    }

    public boolean avanzaRiparazione() {
        if (turniRimanenti > 0) {
            turniRimanenti--;
            if (turniRimanenti == 0) {
                velivoloCorrente.ripara(100.0);
                return true;
            }
        }
        return false;
    }

    public int getTurniRimanenti() {
        return turniRimanenti;
    }
}
