
/**
 * Aggiungi qui una descrizione della classe NumberDisplay
 * 
 * @author Luppi
 * @version 30/09/2025
 */
public class NumberDisplay {
    // variabili d'istanza - sostituisci l'esempio che segue con il tuo
    private int limit;
    private int value;

    public NumberDisplay(int limit) {
        this.limit = limit;
        value = 0;
    }

    /**
     * Metodo getter
     */
    public int getValue() {
        return value;
    }

    /**
     * Metodo setter
     */
    public void setValue(int NewValue) {
        if (NewValue >= 0 && NewValue < limit) {
            this.value = NewValue;
        }
    }

    /**
     * Visualizza il valore del attuale del numero
     */
    public String getDisplayValue() {
        if (value < 10) {
            return "0" + value;
        } else {
            return "" + value;
        }
    }

    /**
     * Incrementa il valore del contatore
     */
    public void increment() {
        value = (value+1) % limit;
    }
}