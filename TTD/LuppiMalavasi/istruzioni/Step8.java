
**************************************************************
*  USER STORY 8                                              *
*  Come arbitro, che il sistema indichi correttamente        *
*  la condizione di parità per non essere multato dalla FIT  *
**************************************************************


    @Test
    public void paritàDeveEssereIlDescrittorePerIlPunteggioQuandoEntrambiHannoFatto3Punti() {
        game.puntoPer("Pippo");game.puntoPer("Pippo");game.puntoPer("Pippo");
        game.puntoPer("Pluto");game.puntoPer("Pluto");game.puntoPer("Pluto");
        assertEquals("parità", game.getPunteggio());
    }

    

