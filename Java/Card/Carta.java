package Java.Card;

public class Carta {
    private String seme;
    private int numero;
    private boolean colore;

    /*
     * Caratteri per il cambio colore del testo
     */
    private static final String RESET = "\u001B[0m";
    private static final String ROSSO = "\u001B[31m";
    // private static final String VERDE = "\u001B[32m";
    // private static final String GIALLO = "\u001B[33m";
    // private static final String BLU = "\u001B[34m";
    // private static final String VIOLA = "\u001B[35m";
    // private static final String AZZURRO = "\u001B[36m";
    // private static final String BIANCO = "\u001B[37m";

    /*
     * Caratteri semi delle carte
     */
    private static final char picche = '\u2660';
    private static final char cuori = '\u2665';
    private static final char quadri = '\u2666';
    private static final char fiori = '\u2663';

    public Carta(String seme, int numero) {
        this.seme = seme.toLowerCase().trim();
        switch (seme) {
            case "fiori":
            case "picche":
                this.colore = false;
                break;

            case "cuori":
            case "quadri":
                this.colore = true;
                break;

            default:
                this.seme = "Non valido";
                this.colore = false;
                break;
        }
        if (numero >= 1 && numero <= 13) {
            this.numero = numero;
        } else {
            this.numero = 1;
        }
    }

    private String getSimboloSeme() {
        char seed = 0;
        switch (seme) {
            case "cuori":
                seed = cuori;
                break;
            case "quadri":
                seed = quadri;
                break;
            case "fiori":
                seed = fiori;
                break;
            case "picche":
                seed = picche;
                break;
        }
        return "" + seed;
    }

    private String getSimboloNumero() {
        switch (numero) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return "" + numero;
        }
    }

    private String getNumeroSeme() {
        String output = "";

        output += getSimboloNumero() + getSimboloSeme();

        return output;
    }

    private String getColoreCarta() {
        String output = "";

        output += (colore ? ROSSO : RESET);

        return output;
    }

    public String toString() {
        String output = "";

        output += getColoreCarta() + "########\n" + RESET;
        output += getColoreCarta() + "#" + getNumeroSeme() + "##" + getNumeroSeme() + "#\n" + RESET;
        output += getColoreCarta() + "#      #\n" + RESET;
        output += getColoreCarta() + "#  " + getNumeroSeme() + "  #\n" + RESET;
        output += getColoreCarta() + "#      #\n" + RESET;
        output += getColoreCarta() + "#" + getNumeroSeme() + "##" + getNumeroSeme() + "#\n" + RESET;
        output += getColoreCarta() + "########\n" + RESET;

        return output;
    }
}
