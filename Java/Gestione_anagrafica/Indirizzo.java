package Java.Gestione_anagrafica;

/*
 * Per prima cosa, crea una classe standalone (che non eredita da nessuno) chiamata Indirizzo.
 * Questa classe verrà contenuta all'interno di Persona.
 * 
 * Attributi (private):
 * 
 * via (String)
 * 
 * numeroCivico (String)
 * 
 * citta (String)
 * 
 * cap (String)
 * 
 * Costruttore:
 * 
 * Deve accettare tutti e quattro i parametri per inizializzare gli attributi.
 * 
 * Metodi:
 * 
 * getIndirizzoCompleto(): Un metodo pubblico che restituisce una singola stringa 
 * formattata con l'indirizzo completo (es. "Via Roma 10, 10100 Torino").
 */

public class Indirizzo {

  private String via;
  private String numeroCivico;
  private String citta;
  private String cap;

  public Indirizzo(String via, String numeroCivico, String citta, String cap) {
    this.via = via;
    this.numeroCivico = numeroCivico;
    this.citta = citta;
    this.cap = cap;
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    str.append("Via " + via + " " + numeroCivico + ", " + cap + " " + citta);
    return str.toString();
  }

}
