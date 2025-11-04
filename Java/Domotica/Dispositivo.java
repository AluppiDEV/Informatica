package Java.Domotica;

public abstract class Dispositivo {

    protected String id;
    protected boolean stato;

    public abstract void accendi();
    public abstract void spegni();
    public abstract String generaRapportoStato();

    public boolean isAcceso() {
        return stato;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
