package Java.Gestione_aeroportuale;

public abstract class Infrastruttura {
    protected String id;
    protected boolean occupato;
    protected Velivolo velivoloCorrente;

    public Infrastruttura(String id) {
        this.id = id;
        this.occupato = false;
        this.velivoloCorrente = null;
    }

    public boolean isOccupato() {
        return occupato;
    }

    public void occupa(Velivolo velivolo) {
        this.occupato = true;
        this.velivoloCorrente = velivolo;
    }

    public void libera() {
        this.occupato = false;
        this.velivoloCorrente = null;
    }

    public String getId() {
        return id;
    }

    public Velivolo getVelivoloCorrente() {
        return velivoloCorrente;
    }
}
