package Java.Card;

public class TestCard {
    public static void main(String[] args) {
        Mazzo mazzo = new Mazzo(5);

        
        mazzo.aggiungiCarta("cuori", 10);
        mazzo.aggiungiCarta("quadri", 11);
        mazzo.aggiungiCarta("fiori", 12);
        mazzo.aggiungiCarta("picche", 13);

        System.out.println(mazzo.toString());
    }
}
