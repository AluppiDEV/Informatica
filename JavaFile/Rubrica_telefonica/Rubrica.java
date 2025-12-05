package JavaFile.Rubrica_telefonica;

import java.util.ArrayList;

public class Rubrica {
    private ArrayList<Contatto> contatti;

    public Rubrica() {
        this.contatti = new ArrayList<>();
    }

    /**
     * Aggiunge un contatto alla rubrica in memoria
     */
    public void aggiungiContatto(String nome, String numero) {
        Contatto nuovoContatto = new Contatto(nome, numero);
        contatti.add(nuovoContatto);
    }

    /**
     * Rimuove un contatto dalla rubrica per nome
     * @return true se rimosso, false se non trovato
     */
    public boolean rimuoviContatto(String nome) {
        return contatti.removeIf(c -> c.getNome().equalsIgnoreCase(nome.trim()));
    }

    /**
     * Rimuove un contatto per indice
     * @return true se rimosso, false se indice non valido
     */
    public boolean rimuoviContatto(int indice) {
        if (indice >= 0 && indice < contatti.size()) {
            contatti.remove(indice);
            return true;
        }
        return false;
    }

    /**
     * Sostituisce tutti i contatti con una nuova lista
     */
    public void setContatti(ArrayList<Contatto> nuoviContatti) {
        this.contatti = nuoviContatti;
    }

    /**
     * Restituisce la rubrica formattata come stringa
     */
    public String stampaRubrica() {
        if (contatti.isEmpty()) {
            return "Rubrica vuota.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("=== RUBRICA (").append(contatti.size()).append(" contatti) ===\n");
        for (int i = 0; i < contatti.size(); i++) {
            sb.append((i + 1)).append(". ")
                    .append(contatti.get(i).getNome())
                    .append(" - ")
                    .append(contatti.get(i).getNumero())
                    .append("\n");
        }
        return sb.toString();
    }

    /**
     * Cerca contatti per nome e restituisce i risultati
     */
    public String cercaContatto(String nome) {
        StringBuilder sb = new StringBuilder("Ricerca '" + nome + "':\n");
        boolean trovato = false;

        for (int i = 0; i < contatti.size(); i++) {
            if (contatti.get(i).getNome().toLowerCase().contains(nome.toLowerCase())) {
                sb.append((i + 1)).append(". ")
                        .append(contatti.get(i).getNome())
                        .append(" - ")
                        .append(contatti.get(i).getNumero())
                        .append("\n");
                trovato = true;
            }
        }

        if (!trovato) {
            sb.append("Nessun contatto trovato.");
        }
        return sb.toString();
    }

    public int getDimensione() {
        return contatti.size();
    }

    public boolean isVuota() {
        return contatti.isEmpty();
    }

    public ArrayList<Contatto> getContatti() {
        return new ArrayList<>(contatti); // restituisce copia per incapsulamento
    }
}
