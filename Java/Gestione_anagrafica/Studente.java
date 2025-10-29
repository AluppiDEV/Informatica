package Java.Gestione_anagrafica;

/*
 * Crea una classe pubblica Studente che eredita da Persona.
 * 
 * Attributi (private):
 * 
 * matricola (String)
 * 
 * Costruttore:
 * 
 * Deve accettare tutti i parametri necessari per costruire una Persona (incluso l'oggetto Indirizzo) più la matricola.
 * 
 * Deve chiamare il costruttore della superclasse (super()) per impostare le informazioni comuni.
 * 
 * Deve inizializzare il suo attributo specifico (matricola).
 * 
 * Metodi (Override):
 * 
 * presentati(): Fai l'override di questo metodo. Deve:
 * 
 * Invocare il metodo presentati() della superclasse (super.presentati()).
 * 
 * Stampare a console la sua informazione specifica (es. "Sono uno studente, matricola: 12345").
 */

public class Studente extends Persona {

    private String matricola;

    public Studente(String nome, String cognome, String codiceFiscale, Indirizzo indirizzo, String matricola) {
        super(nome, cognome, codiceFiscale, indirizzo);
        this.matricola = matricola;
    }

    @Override
    public String presentati() {
        return super.toString() + " Matricola: \"" + matricola + "\"";
    }

}
