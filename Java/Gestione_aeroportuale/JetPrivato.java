package Java.Gestione_aeroportuale;

public class JetPrivato extends AeromobileAMotore {
    public JetPrivato(String id, String modello) {
        super(id, modello, 950.0, 100.0, 4.0, 60);
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
        if (pilota != null && pilota.isAbilitatoPer(modello) && carburante >= 100.0 && !pilota.isOccupato()) {
            pilota.setOccupato(true);
            this.inVolo = true;
            return true;
        }
        return false;
    }
}
