package Java.Assemblaggio_pc;

public class TestAssemblaggio {

  public static void main(String[] args) {
    // Creazione dei componenti
    CPU cpu = new CPU("Intel i7", 300.0, 6, 3.5);
    RAM ram = new RAM("Kingston", 80.0, 32, "DDR4");
    Disco disco = new Disco("Samsung EVO", 100.0, 2, true);

    // Creazione del computer
    Computer pc = new Computer("Gaming Rig", cpu, ram, disco);

    // Percentuale di sconto
    double sconto = 15.0;

    // Stampa della configurazione con sconto
    pc.stampaConfigurazione(sconto);
  }

}
