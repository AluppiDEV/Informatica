    @Test
    public void robustezza() {
        game.puntoPer("Pluto");game.puntoPer("Pluto");
        assertEquals(game.getPunteggio(), "zero, trenta");
        game.puntoPer("Pippo");game.puntoPer("Pippo");
        assertEquals(game.getPunteggio(), "trenta, trenta");
        game.puntoPer("Paperino");game.puntoPer("Paperoga");
        assertEquals(game.getPunteggio(), "trenta, trenta");
        game=new Game("Paperino","Paperoga");
        game.puntoPer("Paperino");game.puntoPer("Paperoga");
        assertEquals("quindici, quindici",game.getPunteggio());
    }
