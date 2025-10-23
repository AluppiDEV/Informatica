import java.util.ArrayList;

public class Ordine {

    private int idOrdine;
    private static int contatoreOrdini = 0;
    private String nomeCliente;
    private ArrayList<RigaOrdine> righe;

    public Ordine(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        righe = new ArrayList<>();
        this.idOrdine = contatoreOrdini;
        contatoreOrdini++;
    }

    public void aggiungiProdotto(Prodotto p, int quantita) {
        boolean found = false;
        int index = 0;
        for (RigaOrdine r : righe) {
            if (r.getProdotto().getSku().equals(p.getSku())) {
                found = true;
                righe.indexOf(r);
            }
        }

        if (found) {
            int qta = righe.get(index).getQuantita();
            righe.get(index).setQuantita(qta + quantita);
        } else {
            righe.add(new RigaOrdine(p, quantita));
        }
    }

    public void rimuoviProdotto(String sku) {
        boolean found = false;
        int index = 0;
        for (RigaOrdine r : righe) {
            if (r.getProdotto().getSku().equals(sku)) {
                found = true;
                righe.indexOf(r);
            }
        }

        if (found) {
            righe.remove(index);
        } else {
            System.err.println("Nessun elemento trovato");
        }
    }

    public double calcolaTotaleOrdine() {
        double tot = 0;
        for (RigaOrdine r : righe) {
            tot += r.getSubtotale();
        }
        return tot;
    }

    public String stampaRicevuta() {
        StringBuilder str = new StringBuilder();
        str.append(idOrdine + " | Cliente:" + nomeCliente + "\n");
        for (RigaOrdine r : righe) {
            str.append(r).append("\n");
        }
        return str.toString();
    }

}
