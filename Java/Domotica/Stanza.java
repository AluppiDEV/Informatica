package Java.Domotica;

public class Stanza {

    private String nomeStanza;
    private LuceIntelligente lucePrincipale;
    private LuceIntelligente luceSecondaria;
    private Termostato termostatoStanza;
    private VideocameraSicurezza videocameraIngresso;

    public Stanza(String nomeStanza, LuceIntelligente L1, LuceIntelligente L2, Termostato T1, VideocameraSicurezza V1) {
        this.nomeStanza = nomeStanza;
        this.lucePrincipale = L1;
        this.luceSecondaria = L2;
        this.termostatoStanza = T1;
        this.videocameraIngresso = V1;
    }

    public void accendiTutto() {
        lucePrincipale.accendi();
        luceSecondaria.accendi();
        termostatoStanza.accendi();
        videocameraIngresso.accendi();
    }

    public void spegniTutto() {
        lucePrincipale.spegni();
        luceSecondaria.spegni();
        termostatoStanza.spegni();
        videocameraIngresso.spegni();
    }

    public String generaRapportoCompletoStanza() {
        return
        lucePrincipale.generaRapportoStato() + "\n" +
        luceSecondaria.generaRapportoStato() + "\n" +
        termostatoStanza.generaRapportoStato() + "\n" +
        videocameraIngresso.generaRapportoStato() + "\n";
    }

    public String getLucePrincipale() {
        return lucePrincipale.generaRapportoStato();
    }

    public String getLuceSecondaria() {
        return luceSecondaria.generaRapportoStato();
    }

    public String getTermostatoStanza() {
        return termostatoStanza.generaRapportoStato();
    }

    public String getVideocameraIngresso() {
        return videocameraIngresso.generaRapportoStato();
    }
}
