package Java.Gestione_aeroportuale;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Aeroporto aeroporto = new Aeroporto();

        aeroporto.aggiungiInfrastruttura(new Pista("Pista-1", 2500));
        aeroporto.aggiungiInfrastruttura(new Pista("Pista-2", 1800));
        aeroporto.aggiungiInfrastruttura(new Pista("Pista-3", 3000));
        aeroporto.aggiungiInfrastruttura(new PiazzolaSosta("Piazzola-A"));
        aeroporto.aggiungiInfrastruttura(new PiazzolaSosta("Piazzola-B"));
        aeroporto.aggiungiInfrastruttura(new HangarRiparazioni("Hangar-1"));
        aeroporto.aggiungiInfrastruttura(new HangarRiparazioni("Hangar-2"));

        aeroporto.aggiungiPilota(new Pilota("Mario Rossi", "P001", List.of("Boeing 737", "Airbus A320")));
        aeroporto.aggiungiPilota(new Pilota("Luca Bianchi", "P002", List.of("Cessna Citation", "Bell 206")));
        aeroporto.aggiungiPilota(new Pilota("Anna Verdi", "P003", List.of("Boeing 747", "Airbus A380")));
        aeroporto.aggiungiPilota(new Pilota("Giuseppe Neri", "P004", List.of("Gulfstream G650", "Aliante ASH-31")));

        aeroporto.aggiungiTecnico(new TecnicoManutentore("Franco", "T001"));
        aeroporto.aggiungiTecnico(new TecnicoManutentore("Paolo", "T002"));

        System.out.println("=== TEST COMPLETO DEL SISTEMA AEROPORTUALE ===\n");

        System.out.println("--- Test 1: Atterraggi con Vincoli di Pista ---");
        AereoDiLinea aereo1 = new AereoDiLinea("AZ-500", "Boeing 737", 180);
        aereo1.consumaCarburante(95.0);
        aeroporto.aggiungiVelivoloInArrivo(aereo1);

        AereoCargo cargo = new AereoCargo("Cargo-102", "Boeing 747", 50000);
        cargo.consumaCarburante(95.0);
        aeroporto.aggiungiVelivoloInArrivo(cargo);

        JetPrivato jet = new JetPrivato("Jet-777", "Gulfstream G650");
        jet.consumaCarburante(90.0);
        aeroporto.aggiungiVelivoloInArrivo(jet);

        System.out.print(aeroporto.simulaTurno());

        System.out.println("--- Test 2: Elicottero su Piazzola ---");
        Elicottero elicottero1 = new Elicottero("Heli-001", "Bell 206");
        elicottero1.consumaCarburante(80.0);
        aeroporto.aggiungiVelivoloInArrivo(elicottero1);
        System.out.print(aeroporto.simulaTurno());

        System.out.println("--- Test 3: Manutenzione Velivolo Danneggiato ---");
        Elicottero elicottero2 = new Elicottero("Heli-002", "Bell 206");
        elicottero2.riduciIntegrita(85.0);
        elicottero2.consumaCarburante(70.0);
        aeroporto.aggiungiVelivoloInArrivo(elicottero2);
        System.out.print(aeroporto.simulaTurno());

        System.out.println("--- Test 4: Avanzamento Riparazione ---");
        System.out.print(aeroporto.simulaTurno());
        System.out.print(aeroporto.simulaTurno());
        System.out.print(aeroporto.simulaTurno());

        System.out.println("--- Test 5: Aliante ---");
        Aliante aliante = new Aliante("Aliante-100", "ASH-31");
        aeroporto.aggiungiVelivoloInArrivo(aliante);
        System.out.print(aeroporto.simulaTurno());

        System.out.println("--- Test 6: Carburante Critico ---");
        AereoCargo cargoEmergenza = new AereoCargo("Cargo-911", "Boeing 747", 60000);
        cargoEmergenza.consumaCarburante(96.0);
        aeroporto.aggiungiVelivoloInArrivo(cargoEmergenza);
        System.out.print(aeroporto.simulaTurno());

        System.out.println("--- Test 7: Tentativo Decollo Senza Pilota Abilitato ---");
        AereoDiLinea aereo2 = new AereoDiLinea("AF-200", "Airbus A380", 500);
        aereo2.consumaCarburante(95.0);
        aeroporto.aggiungiVelivoloInArrivo(aereo2);
        System.out.print(aeroporto.simulaTurno());
        System.out.print(aeroporto.simulaTurno());

        System.out.println("--- Test 8: Condizioni Meteo Variabili ---");
        for (int i = 0; i < 5; i++) {
            System.out.print(aeroporto.simulaTurno());
        }

        System.out.println("\n=== TEST COMPLETATO ===");
    }
}