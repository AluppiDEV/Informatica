
/**
 * Aggiungi qui una descrizione della classe Bedroom
 * 
 * @author Luppi
 * @version 1.0
 */
public class Bedroom {
    // variabili d'istanza - sostituisci l'esempio che segue con il tuo
    private int id;
    private boolean busy;
    private float tarif;
    private int days;
    private Client cliente;

    /*
     * Costruttore
     */
    public Bedroom(int id, float tarif) {
        this.id = id;
        this.tarif = Math.max(0, tarif);
        this.busy = false;
        this.days = 0;
        this.cliente = null;
    }

    /*
     * Getter
     */
    public int getId() {
        return id;
    }

    public boolean getBusy() {
        return busy;
    }

    private float getTarif() {
        return tarif;
    }

    private int getDays() {
        return days;
    }

    /*
     * Ottini il prezzo totale per il noleggio
     */
    private float getTotal() {
        return tarif * days;
    }

    /*
     * Affitta o restituisci la camera
     */
    public void rentBedroom(int days, String clientName, String clientSurname, String clientTaxID) {
        if (!busy) {
            toggleBusy();
            this.days = Math.max(days, 0);
            cliente = new Client(clientName, clientSurname, clientTaxID);
        } else {
            System.out.println("Camera già occupata.");
        }
    }

    public void freeBedroom() {
        if (busy) {
            toggleBusy();
            this.days = 0;
            cliente = null;
        } else {
            System.out.println("Camera già libera.");
        }
    }

    /*
     * Estendi il noleggio
     */
    public void extendRentBedroom(int days) {
        if (days > 0) {
            this.days += days;
        } else {
            System.out.println("Impossibile estendere con un valore negativo.");
        }
    }

    /*
     * Cambia lo stato del noleggio
     */
    private void toggleBusy() {
        busy = !busy;
    }

    /*
     * Ottieni i dati del noleggiatore e per quanto tempo
     */
    public void getBedroomData() {
        if (busy) {
            System.out.println("###########################");
            System.out.println("# ID camera: " + getId());
            System.out.println("###########################");
            System.out.println("# Prenotato per: " + getDays() + " giorni");
            System.out.println("# Al costo di: " + getTarif() + " al giorno");
            System.out.println("# Per un totale di: " + getTotal());
            System.out.println("# Dal cliente: ");
            System.out.println(cliente.getClientData());
            System.out.println("###########################");
        } else {
            System.out.println("########################################");
            System.out.println("# Camera disponibile per la prenotazione");
            System.out.println("########################################");
        }
    }

    /*
     * Richiesta del codice fiscale per controllo cliente
     */
    public String getSecurityCheck() {
        return (cliente != null) ? cliente.getTaxID() : "";
    }

}