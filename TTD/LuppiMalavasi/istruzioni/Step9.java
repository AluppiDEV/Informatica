    @Test
    public void vantaggioGiocatoreDeveEssereIlDescrittorePerIlPunteggioQuandoEntrambiHannoFatto3PuntiEUnoNeHaDiPiù() {
        game.puntoPer("Pippo");game.puntoPer("Pippo");game.puntoPer("Pippo");
        game.puntoPer("Pluto");game.puntoPer("Pluto");game.puntoPer("Pluto");
        game.puntoPer("Pippo");
        assertEquals("vantaggio Pippo",game.getPunteggio());
        game.puntoPer("Pluto");
        assertEquals(game.getPunteggio(), "parità");
        game.puntoPer("Pluto");
        assertEquals("vantaggio Pluto",game.getPunteggio());
    }

