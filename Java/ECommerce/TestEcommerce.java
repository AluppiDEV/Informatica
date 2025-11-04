package Java.ECommerce;

public class TestEcommerce {
    public static void main(String[] args) {
        Ordine o = new Ordine("Alessandro");

        Prodotto p1 = new Prodotto("T-42", "Tastiera", 15);
        Prodotto p2 = new Prodotto("M-38", "Mouse", 30);
        Prodotto p3 = new Prodotto("M-130", "Monitor", 145);
        Prodotto p4 = new Prodotto("C-51", "Cuffie", 40);

        o.aggiungiProdotto(p1, 1);
        o.aggiungiProdotto(p2, 1);
        o.aggiungiProdotto(p3, 1);

        System.out.println(o.stampaRicevuta());

        o.aggiungiProdotto(p2, 1);

        System.out.println(o.stampaRicevuta());

        o.aggiungiProdotto(p4, 1);
        o.rimuoviProdotto("T-42");

        System.out.println(o.stampaRicevuta());

    }
}
