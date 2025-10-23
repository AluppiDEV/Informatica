public class TestEcosistema {

    public static void main(String[] args) {

        Ecosistema ecosistema = new Ecosistema("Riserva Naturale");

        Zona foresta = new Zona("Foresta Boreale");
        Zona fiume = new Zona("Fiume");

        ecosistema.aggiungiZona(foresta);
        ecosistema.aggiungiZona(fiume);

        Animale coniglio1 = new Animale("Coniglio");
        Animale coniglio2 = new Animale("Coniglio");
        Animale lupo = new Animale("Lupo");

        Animale salmone = new Animale("Salmone");
        Animale orso = new Animale("Orso");

        System.out.println(foresta.aggiungiAnimale(coniglio1));
        System.out.println(foresta.aggiungiAnimale(coniglio2));
        System.out.println(foresta.aggiungiAnimale(lupo));

        System.out.println(fiume.aggiungiAnimale(salmone));
        System.out.println(fiume.aggiungiAnimale(orso));

        // provo a riempire la zona
        for (int i = 0; i < 10; i++) {
            System.out.println(fiume.aggiungiAnimale(new Animale("Pesce" + i)));
        }

        System.out.println(ecosistema.mostraReportEcosistema());

    }

}
