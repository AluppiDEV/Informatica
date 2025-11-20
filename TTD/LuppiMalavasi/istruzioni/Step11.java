**************************************************************
*  USER STORY 10                                             *
*  Come giocatore ai vantaggi,voglio vedere il mio nome sul  *
*  segnapunti per inizare a festeggiare                      *
**************************************************************

@Test
public void VittoriaAiVantaggi() {
    game.puntoPer("Pippo");game.puntoPer("Pippo");game.puntoPer("Pippo");game.puntoPer("Pippo");
    game.puntoPer("Pluto");game.puntoPer("Pluto");game.puntoPer("Pluto");game.puntoPer("Pluto");
    game.puntoPer("Pluto");
    game.puntoPer("Pluto");
    assertEquals("Pluto vince", game.getPunteggio());
}
