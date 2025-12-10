package Java.Gestione_aeroportuale;

public abstract class AeromobileAMotore extends Velivolo {
    protected double consumoCarburante;
    protected int rumore;

    public AeromobileAMotore(String id, String modello, double velocita, double carburante, double consumoCarburante, int rumore) {
        super(id, modello, velocita, carburante);
        this.consumoCarburante = consumoCarburante;
        this.rumore = rumore;
    }

    @Override
    public void muoviti() {
        consumaCarburante(consumoCarburante);
        riduciIntegrita(2.0);
    }
}
