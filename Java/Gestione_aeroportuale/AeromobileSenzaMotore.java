package Java.Gestione_aeroportuale;

public abstract class AeromobileSenzaMotore extends Velivolo {
    protected boolean dipendeDalVento;

    public AeromobileSenzaMotore(String id, String modello, double velocita, double carburante) {
        super(id, modello, velocita, carburante);
        this.dipendeDalVento = true;
    }

    @Override
    public void muoviti() {
        riduciIntegrita(1.0);
    }
}
