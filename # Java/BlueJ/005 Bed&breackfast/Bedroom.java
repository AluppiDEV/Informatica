
/**
 * Aggiungi qui una descrizione della classe Bedroom
 * 
 * @author (il tuo nome)
 * @version (un numero di versione o una data)
 */
public class Bedroom {
    // variabili d'istanza - sostituisci l'esempio che segue con il tuo
    private boolean busy;
    private float tarif;
    private Client cliente;

    /*
     * Costruttore
     */
    public Bedroom(float tarif) {
        if (tarif < 0) {
            this.tarif = 0;
        } else {
            this.tarif = tarif;
        }
    }
}