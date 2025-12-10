package Java.Gestione_aeroportuale;

public class AereoCargo extends AeromobileAMotore {
    private double capacitaCarico;

    public AereoCargo(String id, String modello, double capacitaCarico) {
        super(id, modello, 800.0, 100.0, 6.0, 75);
        this.capacitaCarico = capacitaCarico;
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
