package Java.Assemblaggio_pc;

public class CPU extends ComponenteHardware{
  
  private int numeroCore;
  private double frequenzaGhz;

  public CPU(String modello, double prezzo, int numeroCore, double frequenzaGhz) {
    super(modello, prezzo);
    this.numeroCore = numeroCore;
    this.frequenzaGhz = frequenzaGhz;
  }

}
