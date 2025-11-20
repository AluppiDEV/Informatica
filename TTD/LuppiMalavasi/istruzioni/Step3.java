
***********************************************************
*  USER STORY 3                                           *
*  Come giocatore, voglio vedere che il punteggio cambi   *
*  quando faccio un punto per vedere il progresso         *
***********************************************************



    @Test
    public void quindiciDeveEssereIlDescrittorePerIlPunteggio1() {
        game.puntoPer("Pluto");
        assertEquals("zero, quindici", game.getPunteggio());
    }


    Aggiungete questo test e risolvetelo.
    
