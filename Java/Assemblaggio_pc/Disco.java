package Java.Assemblaggio_pc;

public class Disco extends ComponenteHardware {

    private int capacitaTB;
    private boolean isSSD;

    public Disco(String modello, double prezzo, int capacitaTB, boolean isSSD) {
        super(modello, prezzo);
        this.capacitaTB = capacitaTB;
        this.isSSD = isSSD;
    }

    @Override
    public String toString() {
        return "Componente: " + modello + " " + capacitaTB + "TB (" + (isSSD ? "SDD" : "HDD") + ") - "
                + String.format("%.2f", prezzo) + "€";
    }

}
