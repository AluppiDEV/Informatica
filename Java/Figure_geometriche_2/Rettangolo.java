package Java.Figure_geometriche_2;

public class Rettangolo extends Figura{

    private float latoCorto;
    private float latoLungo;

    public Rettangolo(float latoCorto, float latoLungo) {
        this.latoCorto = latoCorto;
        this.latoLungo = latoLungo;
    }

    @Override
    public double calcolaPerimetro() {
        return (latoCorto*2) + (latoLungo*2);
    }

    @Override
    public double calcolaArea() {
        return latoCorto * latoLungo;
    }

}
