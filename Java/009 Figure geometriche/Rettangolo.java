public class Rettangolo extends Forma {

  private double base;
  private double altezza;

  public Rettangolo(String colore, double base, double altezza) {
    super(colore);
    this.base = base;
    this.altezza = altezza;
  }

  @Override
  public double calcolaArea() {
    return base * altezza;
  }

  @Override
  public void stampaDettaglio() {
    super.stampaDettaglio();
    System.out.println("Base: " + base);
    System.out.println("Altezza: " + altezza);
  }

}