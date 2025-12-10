package Java.Gestione_aeroportuale;

public abstract class Velivolo {
    protected String id;
    protected String modello;
    protected double velocita;
    protected double carburante;
    protected double integrita;
    protected boolean inVolo;

    public Velivolo(String id, String modello, double velocita, double carburante) {
        this.id = id;
        this.modello = modello;
        this.velocita = velocita;
        this.carburante = carburante;
        this.integrita = 100.0;
        this.inVolo = false;
    }

    public abstract void muoviti();

    public abstract boolean atterra(Infrastruttura infrastruttura);

    public abstract boolean decolla(Pilota pilota);

    public String getId() {
        return id;
    }

    public String getModello() {
        return modello;
    }

    public double getCarburante() {
        return carburante;
    }

    public double getIntegrita() {
        return integrita;
    }

    public boolean isInVolo() {
        return inVolo;
    }

    public void setInVolo(boolean inVolo) {
        this.inVolo = inVolo;
    }

    public void consumaCarburante(double quantita) {
        this.carburante = Math.max(0, this.carburante - quantita);
    }

    public void riduciIntegrita(double quantita) {
        this.integrita = Math.max(0, this.integrita - quantita);
    }

    public void ripara(double quantita) {
        this.integrita = Math.min(100, this.integrita + quantita);
    }

    public void rifornisci(double quantita) {
        this.carburante = Math.min(100, this.carburante + quantita);
    }

    public boolean isOperativo() {
        return integrita >= 20.0;
    }
}
