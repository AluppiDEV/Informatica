import java.util.ArrayList;

public class TestEcosistema {

    public static void main(String[] args) {

        Ecosistema ecosistema = new Ecosistema("Riserva Naturale");

        Zona foresta = new Zona("Foresta Boreale");
        Zona fiume = new Zona("Fiume");

        ArrayList<Animale> animalissimi1 = new ArrayList<>();
        ArrayList<Animale> animalissimi2 = new ArrayList<>();

        ecosistema.aggiungiZona(foresta);
        ecosistema.aggiungiZona(fiume);

        Animale coniglio1 = new Animale("Coniglio");
        Animale coniglio2 = new Animale("Coniglio");
        Animale lupo = new Animale("Lupo");
        Animale salmone = new Animale("Salmone");
        Animale orso = new Animale("Orso");

        animalissimi1.add(coniglio1);
        animalissimi1.add(coniglio2);
        animalissimi1.add(lupo);

        animalissimi2.add(salmone);
        animalissimi2.add(orso);

        for (Animale a : animalissimi1) {
            System.out.println(
                    foresta.aggiungiAnimale(a) ? "Inderimento avvenuto con successo" : "Errore durante l'inderimeno");
        }

        for (Animale a : animalissimi2) {
            System.out.println(
                    fiume.aggiungiAnimale(a) ? "Inderimento avvenuto con successo" : "Errore durante l'inderimeno");
        }

        // provo a riempire la zona
        for (int i = 0; i < 10; i++) {
            System.out.println(fiume.aggiungiAnimale(new Animale("Pesce" + i)) ? "Inderimento avvenuto con successo"
                    : "Errore durante l'inderimeno");
        }

        System.out.println(ecosistema.mostraReportEcosistema());

    }

}
