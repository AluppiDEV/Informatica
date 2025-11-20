    
    ***********************************************************
    *  USER STORY 12                                          *
    *  Come giocatore, voglio poter vincere al TieBreak       *
    *  per potermi bullare dell'avversario                    *
    ***********************************************************
    
    
    
    @Test
    public void VinciCon7punti() {
        tieBreak.puntoPer("Pippo");tieBreak.puntoPer("Pippo");tieBreak.puntoPer("Pippo");
        tieBreak.puntoPer("Pippo");tieBreak.puntoPer("Pippo");tieBreak.puntoPer("Pippo");
        assertEquals( "6, 0",tieBreak.getPunteggio());
        tieBreak.puntoPer("Pippo");
        assertEquals( "Pippo vince",tieBreak.getPunteggio());

    }




