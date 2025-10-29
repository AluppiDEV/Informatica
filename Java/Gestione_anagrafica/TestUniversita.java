package Java.Gestione_anagrafica;

/*
 * Crea una classe TestUniversita con un metodo main per verificare il funzionamento.
 * 
 * Nel main:
 * 
 * Crea un oggetto Indirizzo per lo studente (es. indirizzoStud).
 * 
 * Crea un oggetto Studente, passando al costruttore i dati anagrafici e l'oggetto indirizzoStud appena creato.
 * 
 * Crea un altro oggetto Indirizzo per il docente (es. indirizzoDoc).
 * 
 * Crea un oggetto Docente, passando i suoi dati e l'oggetto indirizzoDoc.
 * 
 * Stampa una linea di separazione.
 * 
 * Sull'oggetto Studente, chiama i metodi presentati() e stampaIndirizzo().
 * 
 * Stampa un'altra linea di separazione.
 * 
 * Sull'oggetto Docente, chiama i metodi presentati() e stampaIndirizzo().
 * 
 * Punti chiave su cui riflettere:
 * 
 * Qual è la differenza tra la relazione Studente-Persona (Ereditarietà) e la relazione Persona-Indirizzo (Composizione)?
 * 
 * Perché nel costruttore di Studente hai dovuto passare un oggetto Indirizzo?
 * 
 * Come funziona la delega nel metodo stampaIndirizzo() della classe Persona?
 */

public class TestUniversita {
    public static void main(String[] args) {

        // Crea un oggetto Indirizzo per lo studente
        Indirizzo indirizzoStud = new Indirizzo("Via Roma", "10", "Milano", "20100");

        // Crea un oggetto Studente, passando dati anagrafici e indirizzoStud
        Studente studente = new Studente("Luca", "Bianchi", "CODICEFISCALE LUCA", indirizzoStud, "S89923");

        // Crea un oggetto Indirizzo per il docente
        Indirizzo indirizzoDoc = new Indirizzo("Corso Italia", "25", "Torino", "10100");

        // Crea un oggetto Docente, passando dati anagrafici e indirizzoDoc
        Docente docente = new Docente("Maria", "Rossi", "CODICEFISCALE LUCA", indirizzoDoc, "D84537");

        // Linea di separazione
        System.out.println("====================================");

        // Metodi dello studente
        studente.presentati();
        studente.stampaIndirizzo();

        // Linea di separazione
        System.out.println("====================================");

        // Metodi del docente
        docente.presentati();
        docente.stampaIndirizzo();
    }
}
