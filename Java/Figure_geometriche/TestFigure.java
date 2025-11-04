package Java.Figure_geometriche;

public class TestFigure {
  public static void main(String[] args) {
    Forma f1 = new Forma("nero");

    f1.stampaDettaglio();
    System.out.println(f1.calcolaArea());

    System.out.println("-----------------------");

    Rettangolo r1 = new Rettangolo("Rosso", 10, 5);

    System.out.println("Colore: " + r1.getColore());
    r1.stampaDettaglio();
    System.out.println("Area: " + r1.calcolaArea());

  }
}