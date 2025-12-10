package Java.Gestione_aereoportuale;

public class AeromobileAMotore extends Velivolo {
    // Consuma carburante e fa rumore

    public AeromobileAMotore(String model, float speed, int fuel) {
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
