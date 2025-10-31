package Java.Assemblaggio_pc;

public class ComponenteHardware {

  private String modello;
  private double prezzo;

  public ComponenteHardware(String modello, double prezzo) {
    this.modello = modello;
    this.prezzo = prezzo;
  }

  public double getPrezzo() {
    return prezzo;
  }

  @Override
  public String toString() {
    return "Componente: " + modello + " - " + String.format("%.2f", prezzo) + "€";
  }

}
