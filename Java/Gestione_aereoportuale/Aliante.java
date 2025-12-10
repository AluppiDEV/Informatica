package Java.Gestione_aereoportuale;

public class Aliante extends Velivolo {

    /*
    Dipende dal meteo
     */

    public Aliante(String model, float speed, int fuel) {
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
