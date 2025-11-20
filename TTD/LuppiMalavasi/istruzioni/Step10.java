***********************************************************
*  USER STORY 8                                           *
*  Come vincitore,voglio vedere il mio nome sul           *
*  segnapunti per inizare a festeggiare                   *
***********************************************************

@Test
    public void VittoriaSenzaVantaggi() {
        game.puntoPer("Pippo");game.puntoPer("Pippo");game.puntoPer("Pippo");game.puntoPer("Pippo");
        assertEquals(game.getPunteggio(), "Pippo vince");
    }
