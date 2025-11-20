
    ***********************************************************
    *  USER STORY 13                                          *
    *  Come giocatore, voglio poter vincere ai vantaggi       *
    *  al TieBreak per poter finalmente festeggiare           *
    ***********************************************************


Aggiungere a TieBreakTest:

@Test
public void VinciAiVantaggi() {
    tieBreak.puntoPer("Pippo");tieBreak.puntoPer("Pippo");tieBreak.puntoPer("Pippo");
    tieBreak.puntoPer("Pippo");tieBreak.puntoPer("Pippo");tieBreak.puntoPer("Pippo");
    tieBreak.puntoPer("Pluto");tieBreak.puntoPer("Pluto");tieBreak.puntoPer("Pluto");
    tieBreak.puntoPer("Pluto");tieBreak.puntoPer("Pluto");
    assertEquals( "6, 5",tieBreak.getPunteggio());
    tieBreak.puntoPer("Pluto");
    tieBreak.puntoPer("Pluto");
    assertEquals( "6, 7",tieBreak.getPunteggio());
    tieBreak.puntoPer("Pluto");
    assertEquals( "Pluto vince",tieBreak.getPunteggio());

}


    Questo è l'ultimo task da completare. Complimenti!
    Se volete perdere un po' di tempo a rifattorizzare e commentare, meglio.public
    Se volete strafare:

    * Modificate getPunteggio sia in Game che in TieBreak in modo che quando un 
    giocatore vince viene visualizzato il punteggio, tipo "Pippo vince 40 a 15".
    In caso di vittoria ai vantaggi si scrive solo "Pippo vince"
    Nel TieBreak il punteggio va scritto sempre
    ** PRIMA MODIFICARE IL Test
    ** POI MODIFICARE IL CODICE

    
