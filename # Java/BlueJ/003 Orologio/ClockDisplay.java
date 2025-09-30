
/**
 * Aggiungi qui una descrizione della classe ClockDisplay
 * 
 * @author Luppi
 */
public class ClockDisplay {
    // variabili d'istanza - sostituisci l'esempio che segue con il tuo
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;

    public ClockDisplay() {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    public void timeTick() {
        minutes.increment();
        if (minutes.getValue() == 0) {
            hours.increment();
        }
        updateDisplay();
    }

    private void updateDisplay() {
        displayString = hours.getDisplayValue() + " : " + minutes.getDisplayValue();
    }

    public void getTime() {
        System.out.println(displayString);
    }
}