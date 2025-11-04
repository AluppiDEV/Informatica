package Java.Figure_geometriche_2;

public class TestFigure {
    public static void main(String[] args) {
        //Figure
        Rettangolo rect = new Rettangolo(10, 20);
        Cerchio circle = new Cerchio(6);

        System.out.println("Perimetro rect: " + String.format("%.2f", rect.calcolaPerimetro()));
        System.out.println("Area rect: " + String.format("%.2f", rect.calcolaArea()));

        System.out.println("Perimetro circle: " + String.format("%.2f", circle.calcolaPerimetro()));
        System.out.println("Area circle: " + String.format("%.2f", circle.calcolaArea()));
    }
}
