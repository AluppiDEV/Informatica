package Java.Domotica;

public class TestDomotica {
    public static void main(String[] args) {

        // Creazione dei dispositivi
        LuceIntelligente lucePrincipale = new LuceIntelligente("L1");
        LuceIntelligente luceSecondaria = new LuceIntelligente("L2");
        Termostato termostato = new Termostato("T1");
        VideocameraSicurezza videocamera = new VideocameraSicurezza("V1", true);

        // Creazione della stanza con i dispositivi
        Stanza salaRiunioni = new Stanza(
                "Sala Riunioni A",
                lucePrincipale,
                luceSecondaria,
                termostato,
                videocamera
        );

        // Accende tutto
        salaRiunioni.accendiTutto();

        // Imposta parametri specifici
        termostato.impostaLivello(21); // Temperatura target 21°C
        lucePrincipale.impostaLivello(85); // Luminosità 85%

        // Mostra stato completo
        System.out.println(salaRiunioni.generaRapportoCompletoStanza());

        // Spegne tutto
        salaRiunioni.spegniTutto();

        System.out.println("\nDopo spegnimento:");
        System.out.println(salaRiunioni.generaRapportoCompletoStanza());
    }
}
