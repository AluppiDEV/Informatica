package Java.Gestione_aeroportuale;

public class AereoDiLinea extends AeromobileAMotore {
    private int capienzaPasseggeri;

    public AereoDiLinea(String id, String modello, int capienzaPasseggeri) {
        super(id, modello, 850.0, 100.0, 5.0, 80);
        this.capienzaPasseggeri = capienzaPasseggeri;
    }

    @Override
    public boolean atterra(Infrastruttura infrastruttura) {
        if (infrastruttura instanceof Pista) {
            Pista pista = (Pista) infrastruttura;
            if (pista.getLunghezza() >= 2000 && !pista.isOccupato()) {
                pista.occupa(this);
                this.inVolo = false;
                return true;
            }
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
