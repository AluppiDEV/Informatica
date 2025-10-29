package Java.Gestione_anagrafica;

/*
 * Crea la classe base pubblica Persona.
 * Questa classe utilizzerà la composizione per includere un Indirizzo.
 * 
 * Attributi (protected):
 * 
 * nome (String)
 * 
 * cognome (String)
 * 
 * codiceFiscale (String)
 * 
 * indirizzo (di tipo Indirizzo) - Questa è la composizione!
 * 
 * Costruttore:
 * 
 * Deve accettare quattro parametri: nome, cognome, codiceFiscale e un oggetto di tipo Indirizzo.
 * 
 * Deve inizializzare tutti gli attributi.
 * 
 * Metodi:
 * 
 * presentati(): Un metodo pubblico (void) che stampa i dettagli base della persona 
 * (es. "Mi chiamo Nome Cognome (CF: ...)" ).
 * 
 * stampaIndirizzo(): Un metodo pubblico (void) che delega all'oggetto indirizzo il compito di stampare l'indirizzo. 
 * Deve invocare getIndirizzoCompleto() sull'attributo indirizzo e stampare il risultato.
 */

public class Persona {

  protected String nome;
  protected String cognome;
  protected String codiceFiscale;
  protected Indirizzo indirizzo;

  public Persona(String nome, String cognome, String codiceFiscale, Indirizzo indirizzo) {
    this.nome = nome;
    this.cognome = cognome;
    this.codiceFiscale = codiceFiscale;
    this.indirizzo = indirizzo;
  }

  public String presentati() {
    StringBuilder str = new StringBuilder();
    str.append("Mi chiamo " + nome + " " + cognome + " CF: \"" + codiceFiscale + "\"");
    return str.toString();
  }

  public String stampaIndirizzo() {
    return indirizzo.toString();
  }

}
