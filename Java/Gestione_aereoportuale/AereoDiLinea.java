package Java.Gestione_aereoportuale;

public class AereoDiLinea extends Velivolo {

    /*
    Capienza passeggeri
    Richiede piste lunghe
     */

    public AereoDiLinea(String model, float speed, int fuel) {
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
