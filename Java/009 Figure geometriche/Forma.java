public class Forma {

  protected String colore;

  public Forma(String colore) {
    this.colore = colore;
  }

  public String getColore() {
    return colore;
  }

  public double calcolaArea() {
    return 0.0;
  }

  public void stampaDettaglio() {
    System.out.println("Colore: " + colore);
  }

}
