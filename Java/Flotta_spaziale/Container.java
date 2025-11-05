package Java.Flotta_spaziale;

public class Container {

    private String idContainer;
    private double pesoTonnellate;
    private boolean materialePericoloso; // Se true richiede nave sicura

    public Container(String idContainer, double pesoTonnellate, boolean materialePericoloso) {
        this.idContainer = idContainer;
        this.pesoTonnellate = pesoTonnellate;
        this.materialePericoloso = materialePericoloso;
    }

    public String getIdContainer() {
        return idContainer;
    }

    public double getPesoTonnellate() {
        return pesoTonnellate;
    }

    public boolean isMaterialePericoloso() {
        return materialePericoloso;
    }
}
