
/**
 * Aggiungi qui una descrizione della classe Cliente
 * 
 * @author Luppi
 * @version 1.0
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
     * Getter
     */
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getTaxID() {
        return taxID;
    }

    /*
     * Ottenimento dati del cliente
     */
    public String getClientData() {
        return "# Nome: " + name + "\n# Cognome: " + surname + "\n# Codice fiscale: " + taxID;
    }
}