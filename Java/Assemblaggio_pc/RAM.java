package Java.Assemblaggio_pc;

public class RAM extends ComponenteHardware {

    private int capacitaGB;
    private String tipo;

    public RAM(String modello, double prezzo, int capacitaGB, String tipo) {
        super(modello, prezzo);
        this.capacitaGB = capacitaGB;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Componente: " + modello + " " + capacitaGB + "GB " + tipo + " - " + String.format("%.2f", prezzo) + "€";
    }

}
