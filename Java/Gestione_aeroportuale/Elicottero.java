package Java.Gestione_aeroportuale;

public class Elicottero extends AeromobileAMotore {
    public Elicottero(String id, String modello) {
        super(id, modello, 300.0, 100.0, 3.0, 90);
    }

    @Override
    public boolean atterra(Infrastruttura infrastruttura) {
        if ((infrastruttura instanceof PiazzolaSosta || infrastruttura instanceof Pista) && !infrastruttura.isOccupato()) {
            infrastruttura.occupa(this);
            this.inVolo = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean decolla(Pilota pilota) {
        if (pilota != null && pilota.isAbilitatoPer(modello) && carburante >= 100.0 && !pilota.isOccupato()) {
            pilota.setOccupato(true);
            this.inVolo = true;
            return true;
        }
        return false;
    }
}
