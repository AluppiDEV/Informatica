package Java.Gestione_aeroportuale;

public class Aliante extends AeromobileSenzaMotore {
    public Aliante(String id, String modello) {
        super(id, modello, 150.0, 0.0);
    }

    @Override
    public boolean atterra(Infrastruttura infrastruttura) {
        if (infrastruttura instanceof Pista && !infrastruttura.isOccupato()) {
            infrastruttura.occupa(this);
            this.inVolo = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean decolla(Pilota pilota) {
        if (pilota != null && pilota.isAbilitatoPer(modello) && !pilota.isOccupato()) {
            pilota.setOccupato(true);
            this.inVolo = true;
            return true;
        }
        return false;
    }
}
