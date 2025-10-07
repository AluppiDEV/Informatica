
/**
 * Aggiungi qui una descrizione della classe Cliente
 * 
 * @author (il tuo nome)
 * @version (un numero di versione o una data)
 */
public class Client {
    // variabili d'istanza - sostituisci l'esempio che segue con il tuo
    private String name;
    private String surname;
    private String taxID;

    /*
     * Costruttore
     */
    public Client(String name, String surname, String taxID) {
        this.name = name;
        this.surname = surname;
        this.taxID = taxID;
    }

    /*
     * Ottenimento dati del cliente
     */
    public String getData() {
        return "Nome: " + name + " Cognome: " + surname + " Codice fiscale: " + taxID;
    }
}