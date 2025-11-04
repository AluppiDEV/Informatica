package Java.Card;

public class Mazzo {
    private int MAX_CARTE;
    private Carta[] mazzo;
    private int numeroCarte;

    public Mazzo(int MAX_CARTE) {
        this.MAX_CARTE = Math.max(0, MAX_CARTE);
        mazzo = new Carta[this.MAX_CARTE];
    }

    public int getMaxCarte() {
        return MAX_CARTE;
    }

    public void aggiungiCarta(Carta carta) {
        mazzo[numeroCarte] = carta;
        numeroCarte++;
    }

    public void aggiungiCarta(String seme, int numero) {
        mazzo[numeroCarte] = new Carta(seme, numero);
        numeroCarte++;
    }

    public String toString() {
        String output = null;

        output += "Numero attuale di carte: " + numeroCarte+1 + "\n";
        output += "Numero massimo di carte: " + MAX_CARTE + "\n";
        output += "Java.Card.Mazzo di carte:\n\n";
        for (Carta c : mazzo) {
            output += c + "\n";
        }
        output += "";

        return output;
    }
}
