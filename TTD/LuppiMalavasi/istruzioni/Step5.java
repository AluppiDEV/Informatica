

***********************************************************
*  USER STORY 5                                           *
*  Come primo giocatore, voglio vedere se sto per vincere *
***********************************************************



    @Test
    public void quarantaDeveEssereIlDescrittorePerIlPunteggio3() {
        game.puntoPer("Pippo");game.puntoPer("Pippo");game.puntoPer("Pippo");
        assertEquals("quaranta, zero", game.getPunteggio());
    }

   
    Realizzate la US. Potrebbe accadere che sia già verde
    se avete trattato il caso di 40 nella US precedente
    Si tratta di un (lieve) caso di overcoding

