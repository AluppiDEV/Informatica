public class Main {
    public static void main(String[] args) {
        Mazzo m = new Mazzo(5);

        
        m.aggiungiCarta("cuori", 10);
        m.aggiungiCarta("quadri", 11);
        m.aggiungiCarta("fiori", 12);
        m.aggiungiCarta("picche", 13);

        System.out.println(m.toString());
    }
}
