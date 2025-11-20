***********************************************************
*  USER STORY 4                                           *
*  Come altro giocatore, voglio vedere quando vado        *
* in vantaggio per caricarmi                              *
***********************************************************


    @Test
    public void trentaDeveEssereIlDescrittorePerIlPunteggio2() {
        game.puntoPer("Pluto");
        game.puntoPer("Pippo");
        game.puntoPer("Pippo");
        assertEquals("trenta, quindici", game.getPunteggio());
    }


Risolvete questo test