void main() {
    GestoreLogistica gestore = new GestoreLogistica();
    String nomeFile = "database_logistica.dat";

    //prodotti
    TechGadget techGadget1 = new TechGadget("pc", 600, 1200, true, "Apple");
    TechGadget techGadget2 = new TechGadget("smartphone", 200, 1700, true, "Apple");
    ProdottoFresco prodottoFresco1 = new ProdottoFresco("mele", 500, 5, 10, "20/12/2025");
    ProdottoFresco prodottoFresco2 = new ProdottoFresco("carne", 200, 10, 10, "10/1/2026");

    gestore.aggiungiArticolo(techGadget1);
    gestore.aggiungiArticolo(techGadget2);
    gestore.aggiungiArticolo(prodottoFresco1);
    gestore.aggiungiArticolo(prodottoFresco2);

    System.out.println(gestore.stampaTutti());

    if(gestore.serializza(nomeFile)){
        System.out.println("===SERIALIZZATO CON SUCCESSO===");
    } else{
        System.out.println("===NON SERIALIZZATO===");
    }

    GestoreLogistica gestore2 = new GestoreLogistica();

    if(gestore2.deserializza(nomeFile)){
        System.out.println("===DESERIALIZZATO CON SUCCESSO===");
    } else {
        System.out.println("===NON DESERIALIZZATO===");
    }

    System.out.println(gestore2.stampaTutti());
}