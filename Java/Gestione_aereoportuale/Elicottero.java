package Java.Gestione_aereoportuale;

public class Elicottero extends Velivolo {

    /*
    Puo atterrare ovunque
     */

    public Elicottero(String model, float speed, int fuel) {
        super(model, speed, fuel);
    }

    @Override
    public boolean muoviti() {
        return false;
    }

    @Override
    public boolean atterra() {
        return false;
    }

    @Override
    public boolean decolla() {
        return false;
    }
}
