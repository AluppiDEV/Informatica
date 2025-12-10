package Java.Gestione_aeroportuale;

public class Pista extends Infrastruttura {
    private int lunghezza;

    public Pista(String id, int lunghezza) {
        super(id);
        this.lunghezza = lunghezza;
    }

    public int getLunghezza() {
        return lunghezza;
    }
}
