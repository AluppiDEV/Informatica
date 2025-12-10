package Java.Gestione_aereoportuale;

public abstract class Velivolo {

    private static int ID_COUNTER = 1;
    private String id;
    private String model;
    private float speed;
    private int fuel;

    public Velivolo(String model, float speed, int fuel) {
        this.id = "" + ID_COUNTER;
        this.model = model;
        this.speed = speed;
        this.fuel = fuel;
        ID_COUNTER++;
    }

    public abstract boolean muoviti();

    public abstract boolean atterra();

    public abstract boolean decolla();

    public void refuel() {
        this.fuel = 100;
    }

}
