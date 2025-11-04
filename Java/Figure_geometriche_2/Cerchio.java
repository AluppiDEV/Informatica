package Java.Figure_geometriche_2;

public class Cerchio extends Figura {

    private float raggio;

    public Cerchio(float raggio) {
        this.raggio = raggio;
    }

    @Override
    public double calcolaPerimetro() {
        return raggio * 2 * Math.PI;
    }

    @Override
    public double calcolaArea() {
        return raggio * raggio * Math.PI;
    }
}
